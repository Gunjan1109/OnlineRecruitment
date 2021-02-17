<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>multiple-choice quiz form</title>

</head>

<body bgcolor=#ffffff>

<h3>Vocabulary Quiz I</h3>

<form method="post" action="CandidateMain.jsp" enctype="text/plain">

<div class="test">
Check the answer to each multiple-coice question, and click on the "Send Form" button to submit the information.


<P>1. The word which means "house" is:<BR>
<input type="radio" name="1.The word which means house is" value="maison">maison<BR>
<input type="radio" name="1.The word which means house is" value="quatre">quatre<BR>
<input type="radio" name="1.The word which means house is" value="soleil">soleil<BR>
<input type="radio" name="1.The word which means house is" value="poisson">poisson<BR>
</p>

<P>2. The word which means "fish" is:<BR>
<input type="radio" name="2. The word which means fish is" value="maison">maison<BR>
<input type="radio" name="2. The word which means fish is" value="valise">valise<BR>
<input type="radio" name="2. The word which means fish is" value="soleil">soleil<BR>
<input type="radio" name="2. The word which means fish is" value="poisson">poisson<BR>
</p>

<P>3. The word which means "suitcase" is:<BR>
<input type="radio" name="3. The word which means suitcase is" value="renard">renard<BR>
<input type="radio" name="3. The word which means suitcase is" value="valise">valise<BR>
<input type="radio" name="3. The word which means suitcase is" value="soleil">soleil<BR>
<input type="radio" name="3. The word which means suitcase is" value="poisson">poisson<BR>
</p>

<br>
<br>
<br>
<br>
</div>
<input type="submit"  value="Send Form">
<input type="reset" value="Clear Form">
</form>
</body>
</html>