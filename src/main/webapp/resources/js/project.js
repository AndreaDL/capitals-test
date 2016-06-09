
$(document).ready(function(){

	init();
});

function init(){
	var application = new Application();
		
	application.dropdownInit();

	var validator = application.createValidator();
	
	$("#formGeo").form(
	{
		fields: validator.fields,  
		onSuccess : function(event){
			event.preventDefault(); 
			application.ajaxCall();
			
			$(".formTest").transition("slide right");
			
			$(".buttonStartTest").prop("disabled",true);
			}
		});
	
	$("#formTest").form({
		
		onSuccess : function(event){
			event.preventDefault();
			
			application.correctMissedStates(application.checkFormTest());
		}
	});
	
	$(".repeatIcon").popup();
	
	application.allCapitals();
	application.resetPage();
}

function Application(){
	
	var self = this;
	
	var mapStateCapital;
	
	var numberOfStateToGuess = $(".stateCapital").length;
	
	this.ajaxCall = function(){
		
		var formData = $("#formGeo").form("get values");
		formData.continent = formData.continent.split(",");
		
		$.ajax({
			url : "index",
			dataType : "json",
			contentType : "application/json; charset=UFT-8",
			data : JSON.stringify(formData),
			type : "POST",
			success : function(data){
				console.log(data);
				mapStateCapital = data;
				
				self.updateFormTest(self.startTest(data));
			}
		});
	},
	
	this.createValidator = function(){
		
		var validator = {
				fields:{
					continent:{
						identifier : 'continent',
						rules: [{
							type:'empty'
						}]
					}
				}
		};
		
		return validator;
	},
	
	this.startTest = function(mapStateCapital){
		
		var states = Object.keys(mapStateCapital);
		var numberOfStates = states.length;
		var counter = 0;
		var setStates = [];
		
		var checker = function(array){
			
			var randomNumber = Math.floor(Math.random() * numberOfStates );
			var value = states[randomNumber];
			if(! array.includes(value))
				array.push(value);
			else
				checker(array);
		}
		
		for(var i = 0; i < numberOfStateToGuess; i++){
			
			checker(setStates);
		}
		
		sets = setStates;
		return setStates;
	},
	
	this.updateFormTest = function(setStates){
		
		var arrayLabel = $(".stateCapital");
		
		for(var i = 0; i < arrayLabel.length; i++){
			
			var value = setStates[i];
			
			$(".formTest .field")[i].getElementsByTagName("a")[0].innerHTML =
				value+" <i class='" +value.toLowerCase() +" flag'></i>";
			
			arrayLabel[i].getElementsByTagName("input")[0].name = value;
		}
	},
	
	this.dropdownInit = function(){
		
		$(".continentListD").dropdown({
			apiSettings:{
				url : 'continentList'
			}
		});

		$(".prova").dropdown();
	},
	
	this.allCapitals = function(){		
		
		$.ajax({
			url : "capitals",
			dataType : "json",
			contentType : "application/json; charset=UFT-8",
			type : "GET",
			success : function(capitals){

				$(".ui.search").search({
					source : capitals.results,
					searchFields : ["title"],
					searchFullText: true
				});
			}
		});
		
	},
	
	this.checkFormTest = function(){
		
		var counter = 0;
		var userForm = $("#formTest").form("get values");
		var array = Object.keys(userForm);
		var arrayMissedStates = [];
		
		for(var state in array){
			if(userForm[array[state]] === mapStateCapital[array[state]])
				counter++;
			else{
				console.log(array[state] +"    "+mapStateCapital[array[state]]);
				arrayMissedStates.push(array[state]);
			}
		}
		console.log(counter);
		
		$("#finalResult").html("<i class='checkered flag loading icon'></i>" +
				"<h3> You scored "+counter+" out of "+numberOfStateToGuess+"</h3>"+
				"<i class='flag loading icon'></i>");
		
		$(".userScore").modal('setting', 'transition', 'horizontal flip')
		.modal("show");
		
		return arrayMissedStates;
	},
	
	this.messageHandler = function(){
		
		$('.message .close')
		  .on('click', function() {
		    $(this)
		      .closest('.message')
		      .transition('fade');
		  });	
		
	},
	
	this.resetPage = function(){
		
		$(".repeatIcon").on("click", function(){
			
			if($(".formTest").is(":visible")){
				$("#formTest").form("clear");
				$(".formTest").transition("slide left")
			
				$(".correction").html("");
				$(".correction").css("display","none");
			
				$(".buttonStartTest").prop("disabled", false);
			}
			else{
				if($(".buttonStartTest").is(":disabled"))
					$(".buttonStartTest").prop("disabled",false);
			}
		});
	},
	
	this.correctMissedStates = function(arrayMissedStates){
		
		console.log(arrayMissedStates);
		var allState = $(".stateCapital");
		for(var i = 0; i < allState.length; i++){
			
			var item = allState[i];
	
			if( $.inArray(item.getElementsByTagName("input").item(0).name, arrayMissedStates) >= 0 ){
				
				var correction = 
					allState[i].getElementsByClassName("ui pointing label")[0];
				
				correction.style.display="block";
				correction.style.color="#8B0000";
				correction.innerHTML = mapStateCapital[item.getElementsByTagName("input").item(0).name];
			
			}
				
		}
	}
}
