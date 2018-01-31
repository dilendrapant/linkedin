</br>
<p class="lead">List of Peoples</p>

<div class="list-group">


	<c:forEach items="${peoples}" var="people">
		<a href="${contextRoot}/show/people/${people.id}/peoples"
			class="list-group-item" id="a_${people.name}">${people.name}</a>
	</c:forEach>

</div>