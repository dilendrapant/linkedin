<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>


		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">


			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>


						</ol>
					</c:if>
					
					
					<c:if test="${userClickPeoplePeoples == true}">
						<ol class="breadcrumb">

						<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Peoples</li>
							<li class="active">${people.id}</li>
							<li class="active">${people.name}</li>
							<li class="active">${people.education}</li>
							<li class="active">${people.experience}</li>
							<li class="active">${people.profile}</li>
													


						</ol>
						 Lnkedin <a> ${people.url}</a>
						
					</c:if>
					

				</div>


			</div>




		</div>



	</div>






</div>

