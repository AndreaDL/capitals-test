<!doctype html>
<html>
<head>
<meta charset=utf-8>
<title>Index</title>

<script src="http://semantic-ui.com//javascript/library/jquery.min.js"></script>
<script src="http://semantic-ui.com/dist/semantic.min.js"></script>
<link rel="stylesheet" type="text/css" class="ui"
	href="http://semantic-ui.com/dist/semantic.min.css">



<script src="resources/js/project.js"></script>

</head>

<body>

	<br>
	<div align="center">
		<h2>Fun with capitals!</h2>
	</div>
	<br>

	<form id="formGeo" class="ui form segment success container">

		<div class="fields">

			<div class="field">
				<div class="ui sub header">Continents:</div>
				<div
					class="ui multiple search selection dropdown field continentListD">
					<input name="continent" type="hidden"> <i
						class="dropdown icon"></i>

					<div class="default text">Continent</div>
					<div class="menu"></div>
				</div>
			</div>

		</div>

		<div align="center">
			<button class="ui primary button buttonStartTest">Start</button>
			
			<i class="ui big grey repeat link icon repeatIcon" title="Play again!"></i>
			
		</div>
		
	</form>

	<form class="ui form stacked segment center aligned container formTest"
		id="formTest" style="display: none">

		<div class="ui grid">

			<div class="ui category search field four wide column stateCapital">

				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
					<div class="ui pointing label correction" style="display: none">
      						
    				</div>

				<div class="results"></div>

			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
					<div class="ui pointing label correction" style="display: none">
      						
    				</div>

				<div class="results"></div>
			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
						<div class="ui pointing label correction" style="display: none">
      						
    					</div>

				<div class="results"></div>
			</div>



			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
					
					<div class="ui pointing label correction" style="display: none">
      						
    				</div>

				<div class="results"></div>
			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
						<div class="ui pointing label correction" style="display: none">
      						
    					</div>

				<div class="results"></div>
			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
						 <div class="ui pointing label correction" style="display: none">
      						
    					</div>

				<div class="results"></div>
			</div>


			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
					<div class="ui pointing label correction" style="display: none">
      						
    				</div>

				<div class="results"></div>
			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
						<div class="ui pointing label correction" style="display: none">
      						
    					</div>

				<div class="results"></div>
			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
						<div class="ui pointing label correction" style="display: none">
      						
    					</div>

				<div class="results"></div>
			</div>

			<div class="ui category search field four wide column stateCapital">
				<a class="ui icon label"> </a> <input class="prompt" name=""
					type="text">
						<div class="ui pointing label correction" style="display: none">
      						
    					</div>

				<div class="results"></div>
			</div>


		</div>

		<div align="center">
			<button class="ui primary button">Check Out</button>
		</div>

	</form>

	<div class="ui small modal userScore">
		<i class="close icon"></i> 
		<div class="content">
			<div id ="finalResult" align="center"></div>
		</div>
	</div>

</body>

</html>
