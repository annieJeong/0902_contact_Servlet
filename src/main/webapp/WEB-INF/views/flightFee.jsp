<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>항공 요금 계산</h1>
<form action="flightFeeCalc" method="post">
	<h2>인원 :
	성인<select name="numOfAdult">
	<option value=0>선택해주세요</option>
	<option value=1>1</option>
	<option value=2>2</option>
	<option value=3>3</option>
	<option value=4>4</option>
	</select>
	
	어린이<select name="numOfChild">
	<option value=0>선택해주세요</option>
	<option value=1>1</option>
	<option value=2>2</option>
	<option value=3>3</option>
	<option value=4>4</option>
	</select>
	
	유아<select name="numOfKids">
	<option value=0>선택해주세요</option>
	<option value=1>1</option>
	<option value=2>2</option>
	<option value=3>3</option>
	<option value=4>4</option>
	</select>
	</h2>
	<h2>목적지
	<input type="radio" value="newyork" name="dest" checked>newyork
	<input type="radio" value="bangkok" name="dest">bangkok
	<input type="radio" value="sydney" name="dest">sydney
	</h2>
	<input type="submit" value="항공요금 계산하기">
</form>
</body>
</html>