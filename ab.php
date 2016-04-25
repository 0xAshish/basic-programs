<?php
file_put_contents("file.zip", fopen("https://affiliate-feedfiles.snapdeal.com/download/jxpbvdvwreezhvydcgvu/Eyewear.xml.zip", 'r'));

$file = 'file.zip';
$path = pathinfo(realpath($file), PATHINFO_DIRNAME);

$zip = new ZipArchive;
$res = $zip->open($file);
if ($res === TRUE) {

  $zip->extractTo($path);
  $zip->close();
  echo "$file extracted to $path";
} else {
  echo "error in opening $file";
}
  $xml=simplexml_load_file("file:///var/www/html/Eyewear.xml");
 					//       print_r($xml);
	//To extract only 100 product 
          for($i=0;$i<10;$i++){

          $id=$xml->entry[$i]->id;  
          echo "ID->",$id,PHP_EOL;
	  	  
          $title=$xml->entry[$i]->title;  
          echo "Title->",$title,PHP_EOL;
	  
          $link=$xml->entry[$i]->link;  
          echo "Link->",$link,PHP_EOL;
	  
	  $offer_price=$xml->entry[$i]->offer_price;  
          echo "Offer Price->",$offer_price,PHP_EOL;
	  
	  echo PHP_EOL;
  }
         
        ?>

