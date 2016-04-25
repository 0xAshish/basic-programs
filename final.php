
<?php
$m = new MongoClient();//conection to mongodb
$db = $m->mydb;//select database
$product_cat_list=array("Eyewear","Appliances","Automobiles","Automotive","Baby_Care","Bags_Luggage","Beauty_Personal_Care",
"Books","Boys_Clothing_28_Yrs","Tweens_Boys","Cameras_Accessories","Chocolates_Snacks","Click_and_Collect",
"Computers_Peripherals","Digital_Entertainment","Eyewear","Fashion_Accessories","Fashion_Jewellery",
"Fragrances","Furniture","Gaming","Gifting_Events","Girls_Clothing_28_Yrs","Girls_Clothing_814_Yrs",
"Gourmet","Handbags_Clutches","Health_Wellness_Medicine","Hobbies","Home_Decoratives","Home_Furnishing",
"Home_Improvement","Home_Services","Household_Essentials","Infant_Wear","Jewellery","Kids_Decor","Kids_Footwear",
"Kitchen_Appliances","Kitchenware","Mens_Clothing","Mens_Footwear","Mens_Fragrances","Mobiles_Tablets",
"Movies_Music","Musical_Instruments","Nutrition_Supplements","Office_Equipment","Online_Education",
"Precious_Jewellery","Real_Estate","Refurbished_Products","Snapdeal_Select","Sports_Fitness","Stationery",
"TV_Shop","TVs_Audio_Video","The_Designer_Studio",
"Hardware_Sanitary_Fittings","Toys_Games","Watches","Womens_Clothing","Womens_Ethnic_Wear",
"Womens_Footwear","World_Food_Indian_Food");
for($index=0;$index<sizeof($product_cat_list);$index++){
//$collection = $db->mycol;//selcet collection
//$cursor = $collection->drop();
//$collection= $db->mycol;

$dlink="https://affiliate-feedfiles.snapdeal.com/download/jxpbvdvwreezhvydcgvu/".$product_cat_list[$index].".xml.zip";// dynamic link for downloading product
echo PHP_EOL.$dlink.PHP_EOL;
file_put_contents("file.zip",fopen($dlink, 'r'));//download file into file.zip

$file = 'file.zip';
$path = pathinfo(realpath($file), PATHINFO_DIRNAME);//path of that extracted file

$zip = new ZipArchive;
$res = $zip->open($file);
if ($res === TRUE) {
  $zip->extractTo($path);//extract zip file
  $zip->close();
  echo "$file extracted to $path";
} else {
  echo "error in opening $file";
}

$str="file://".$path."/".$product_cat_list[$index].".xml";//dynamic path for xml file
  $xml=simplexml_load_file($str);//"file:///var/www/html/Eyewear.xml");//load xml file into $xml
 echo PHP_EOL.$str.PHP_EOL;	
         for($i=0;$i<sizeof($xml);$i++){
          $id=$xml->entry[$i]->id; // echo $id.PHP_EOL;
          $title=$xml->entry[$i]->title; //echo $title.PHP_EOL;
	  $description=$xml->entry[$i]->description; //echo $description.PHP_EOL;
	  $brand=$xml->entry[$i]->brand; //echo $brand.PHP_EOL;
          $link=$xml->entry[$i]->link;  //echo $link.PHP_EOL;
	  $image_link=$xml->entry[$i]->image_link; //echo $image_link.PHP_EOL;
          $offer_price=$xml->entry[$i]->offer_price; //  echo $offer_price.PHP_EOL;
  	  $mrp=$xml->entry[$i]->mrp; // echo $mrp.PHP_EOL;
	  $availability=$xml->entry[$i]->availability;  //echo $availability.PHP_EOL;
	  $effective_price=$xml->entry[$i]->effective_price; // echo $effective_price.PHP_EOL;
	$document= array( 
	"id" => $id,
	"title" => $title,
	"description" =>$description, 
	"brand" => $brand,      
	"link" => $link,
	"image_link" => $image_link,
	"offer_price" => $offer_price,
	"mrp" => $mrp,
	"availability" => $availability,
	"effective_price" => $effective_price,
	   );
   //$collection->insert($document);//insert into db
  }
   
          
 echo sizeof($xml)."Document inserted successfully".PHP_EOL;
}        

?>

