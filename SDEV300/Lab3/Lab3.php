<!-- PHP and Functions
 Date: June 03, 2019
 Author: Kresimir Tokic
 Title: Lab3.php
 description: Table with math and string functions
 -->
 <!DOCTYPE html>
<html>
<head>
  <title>Lab 3 PHP</title>
</head>
<body>

<h1>Lab 3 PHP</h1>
<?php
// Create arrays
$xValues = array(2,5,8,10);
$rValues = array(2,6,10,100,1000);
$vValues = array(10,30,327,1200);
echo "<h3> Table 1 </h3>";
// Create a table and display the numbers

echo "<table border='1'>";
echo "<tr>
        <th> x Value </th>
        <th> y = -2(x)+ 0 </th>
      </tr>";
 foreach ( $xValues as $x ) {
    echo "<tr>";
    echo "<td>" . $x . "</td>";
    echo "<td>" . slope($x). "</td>";   
  }
  	echo"<tr>
		<th> r Values </th>
        <th> A = 4 * 3.14 * r^2 </th>
		</tr>";
		
  foreach ($rValues as $r) {
	echo "<tr>";
	echo "<td>" . $r . "</td>";
	echo "<td>" . surface($r) . "</td>";
	//echo "</tr>";
  }
  
echo "<tr>
		<th> v Values </th>";
		//<th> d = v * t </th>";
		for ($i = 0; $i <= 10; $i += 0.5) {
			echo "<th> d=v*" . $i . "</th>";
		}
		
        //<th colspan='21'> d = v * {0, 0.5, 1, 1.5....10}  </th>
		echo "</tr>";
		
		foreach ($vValues as $v) {
			echo "<tr>";
			echo "<td>" . $v . "</td>";
			for ($i = 0; $i <= 10; $i += 0.5) {
				echo "<td>" . distance($v, $i) . "</td>"; 
		}
	}
		
echo "</table>";

//slope function returns y=-2x+0
function slope($x) {
	return $y=-2 * $x +0;
}

//surface function returns a=4(pi)r^2
function surface($r) {
	return $a=4 * 3.14 * $r**2;
}

//distance funciton returns d=vt
function distance($v, $i) {
	return $d = $v * $i;
}
?>

<?php 

//create variables
$lyrics = ("In another times forgotten space
Your eyes looked from your mothers face
Wallflower seed on the sand and stone
May the four winds blow you safely home
Ill tell you where the four winds dwell
In franklins tower there hangs a bell
It can ring turn night to day
It can ring like fire when you loose your way
God save the child that rings that bell
It may have one good ring baby you cant tell
One watch by night one watch by day
If you get confused listen to the music play");

echo "<h3> Table 2 </h3>";
echo "<table border='1'>";
echo "<tr>
        <th> Original Quote </th>
        <th> Capitalize First Letter of Each Word </th>
      </tr>";
	  
echo "<tr>";
	echo "<td>" . $lyrics . "</td>";
	echo "<td>" . capitalize($lyrics) . "</td>";
echo "</tr>";

  	echo"<tr>
		<th> Original Quote </th>
        <th> Word Length </th>
		</tr>";
		
		echo "<tr>";
echo "<td>" . $lyrics . "</td>";
echo "<td>" . wordLength($lyrics) . "</td>";
echo "</tr>";


echo "<tr>
		<th> Original Quote </th>
		<th> Shuffled Words </th>
		</tr>";
echo "<tr>";
echo "<td>" . $lyrics . "</td>";
echo "<td>" . wordShuffle($lyrics) . "</td>";
echo "</tr>";

function capitalize($words) {
	return ucwords($words);
}	

function wordLength($lyrics) {
	$lyricsArray = explode(" ", $lyrics);
	$lengthArray = array();
	for ($x = 0; $x < count($lyricsArray); $x++){
		$lengthArray[] = strlen($lyricsArray[$x]);
	}
	return join(", ", $lengthArray);
}

function wordShuffle($lyrics) {
	$lyricsArray = explode(" ", $lyrics);
	$shuffledArray = array();
	for ($x = 0; $x < count($lyricsArray); $x++){
		$shuffledArray[] = str_shuffle($lyricsArray[$x]);
	}
	return join(" ", $shuffledArray);
}
	
	
?>
	
</body>
</html>
