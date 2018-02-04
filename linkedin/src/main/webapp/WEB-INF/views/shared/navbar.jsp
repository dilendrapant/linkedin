<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">Home</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<form action="addUrl" method="post" sid="addUrlForm">
				<a style="color: blue;">Add Profile </a> Email: <input type="text"
					name=email placeholder="Your LinkedinID/Email"> Password: <input
					type="password" name=password placeholder="password">
				Linkedin_User_ID : <input type="text" name=urls
					placeholder="eg. pant,Manoj,ab-cd"> <input type="submit"
					value="Next">
			</form>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>