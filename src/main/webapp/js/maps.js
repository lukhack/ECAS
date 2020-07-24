var map;
var currentMarker = null;
var collection = new Array();
var Polys = new Array();
var position=0;
var panorama;
var fenway = {lat: 4.862920857490681, lng: -74.07137777252194};
var activarmedir= false;    
var activarMarker= false;    
var drawingMap;
var MarkerSuelo;
var listenerLupa;




var styleArray =  [];
  
window.onload = function(){
    try{
        map=PF("gmap").getMap();
        
        map.setOptions({styles:styleArray,scaleControl: true,zoomControl: true});
    } catch (exception) {}

};

var icon2= {
  url: 'images/markerIconTransparent.png',
  size: new google.maps.Size(20, 20),
  origin: new google.maps.Point(0, 0),
  anchor: new google.maps.Point(0, 20),
  scaledSize: new google.maps.Size(15, 15),
  labelOrigin: new google.maps.Point(9, 8)
}

var lineSymbol = {
    path: 'M 0,-1 0,1',
    strokeOpacity: 1,
    color:"Red",
    scale: 4
};


 

function senMail(){
    PF('statusDialog2').show();
    
    
    var w = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;

    var h = window.innerHeight
    || document.documentElement.clientHeight
    || document.body.clientHeight;
    
    var element= $('body,html');
    PF('emailDialog').hide();
    
    html2canvas(element, {
        useCORS: true,
        onrendered: function (canvas) {
            var data = canvas.toDataURL('image/png');
            rcName([{name:'img', value: data}]);
            PF('statusDialog2').hide();
        },
        width:w,
        height:h
     });
    
    
      
    
  }    
var marker;
function handleEvent(event) {
    // document.getElementById('lng').value = event.latLng.lng();
        try {
            str = JSON.stringify(event[0]);
              alert(event.params.toSource());
              alert(event.params[1].value);
              alert(event.params[2].value);
        }
        catch(err) {
             alert(err.message);
        }
 }




function findMe() {
    createMap();               
    navigator.geolocation.getCurrentPosition(
        function(position) {
           latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
           fenway=latlng;
            map.setCenter(latlng);
            
            showMarkerView(position.coords.latitude, position.coords.longitude);
            //marker.addListener('drag', handleEvent);
            google.maps.event.addListener(marker,"dragend",handleEvent);
            google.maps.event.addListener(marker,"click",toggleBounce);


        },
        function(error) {
                alert("No esta habilitado compartir la posición o el sitio no es seguro.");
        },
        {
           enableHighAccuracy: true
        });
}
                
function findPosition(lat,log,zoom){
    try{
        latlng = new google.maps.LatLng(lat, log);
        fenway=latlng;
        map.setCenter(latlng);
        map.setZoom(zoom)
    }catch (exception) {
        
    }

}                
 
function clearMap(){
 for (var i = 0; i < markersArray.length; i++ ) {
    markersArray[i].setMap(null);
  }
  markersArray.length = 0;
}



function createMap(){
    map=PF("gmap").getMap();
    map.setOptions( {scaleControl: true});
    map.setOptions({styles:styleArray});
}

var icon= {
    url: 'images/markerIcon.png',
    size: new google.maps.Size(20, 20),
    origin: new google.maps.Point(0, 0),
    anchor: new google.maps.Point(5, 7),
    scaledSize: new google.maps.Size(15, 15),
    labelOrigin: new google.maps.Point(0, 30)
}
  
function gmapPrint() {
    var content = PF("gmap").getMap(); // get you map details
    var newWindow = window.open(); // open a new window
    newWindow.document.write(content.innerHTML); // write the map into the new window
    newWindow.print(); // print the new window
}

var listener1= null;      
function activarMedir(estado){
    createMap();
    if(estado){
        if(listener1===null){
            listener1 = map.addListener('click', addMarker);
            PF('dialosMedirActivado').show()
        }
        activarmedir=estado;
    }else{
        google.maps.event.removeListener(listener1);
        activarmedir=estado;
        listener1 = null;
        activarmedir=estado;
        calcularArea();
    }
}       
        
       

function calculaPuntoMedio(marcadorA,marcadorB)
{
    try{   //miramos si existe el marcador o lo hemos creado anteriormente
        var distancia=google.maps.geometry.spherical.computeDistanceBetween (marcadorA.getPosition(),marcadorB.getPosition())/1000;
        distancia=distancia.toPrecision(4);

        marcadorB.setLabel({
            text: distancia + " Km",
            color:"black",
            fontSize:"14px"
        });
       
    
     marcadorA.set('distancia', distancia);
     calcularArea();
    
    }catch (exception) {
        console.log(exception);
    }
}

function calcularArea(){
    area=0;
    for(i=0;i<collection.length-1;i++){
        area =area+parseFloat(collection[i].get('distancia'));
    }
    
    $("#total").text(area);
}
function pintarPoly(marcadorA,marcadorB, polys) {
   var path = [marcadorA.getPosition(), marcadorB.getPosition()];
   //poly.setMap(null);
    polys.setPath(path);

}

function showCursorMouse(cursor){
    //crosshair
    //undefined
   map.setOptions({draggableCursor:cursor});
}
            
function addMarker(event) {
    
    

     var object_marker = new google.maps.Marker({
        position:event.latLng,
          map: map,
          draggable: true,
          icon:icon
    });

    collection.push(object_marker);

    calculaPuntoMedio(collection[position-1],collection[position]);
    if(position > 0){
          var poly2 = new google.maps.Polyline({
             strokeOpacity: 0,
             map: map,
             strokeColor: "gray",
             icons: [{
                icon: lineSymbol,
                offset: '0',
                repeat: '20px'
               }]  
           });        
          Polys.push(poly2);
          pintarPoly(collection[position-1],collection[position],Polys[position-1]);
    }     

    (function (marker,positions) {
            google.maps.event.addListener(marker, "position_changed", function (e) {
                 console.info(positions-1+":"+positions+":"+positions+1)

                    if(positions!=0){ 
                         try{calculaPuntoMedio(collection[positions-1],collection[positions]);}catch (exception) {}
                         try{calculaPuntoMedio(collection[positions],collection[positions+1]);}catch (exception) {}

                         try{pintarPoly(collection[positions-1],collection[positions],Polys[positions-1]);}catch (exception) {}
                         try{pintarPoly(collection[positions],collection[positions+1],Polys[positions]);}catch (exception) {}
                    }else{
                        try{calculaPuntoMedio(collection[positions],collection[positions+1]);}catch (exception) {}
                    }
                    try{pintarPoly(collection[positions],collection[positions+1],Polys[positions]);}catch (exception) {}
                    
                   calcularArea();
                    
                    
                    
            });

    })(collection[position],position);

            position++;
            console.warn("position:"+position);
}

function borrarAllPunto(){
   
   try{ 
       
      for (i=0;i<collection.length;i++){
           collection[i].setMap(null);  
       }
       
       for(i=0;i<Polys.length;i++){
            Polys[i].setMap(null);   
       }
       
        collection = new Array();
        Polys = new Array();
        position=0;
        
        calcularArea();
    }catch (exception) {
        console.log(exception);
    }

}

function borrarUltimoMarker(){
    
   try{ 
       countRow=collection.length;
      if(countRow>0) {
         console.log(countRow);
         collection[collection.length-1].setMap(null);  
         
         
         
         if(countRow===1){
             console.log("me volvi a crear 2");
             collection = new Array();
             Polys = new Array();
             position=0;
         }else{
            Polys[Polys.length-1].setMap(null);  
            console.log("me volvi a crear 1");
            position=position-1; 
            collection.splice(collection.length-1, 1);
            Polys.splice(Polys.length-1, 1);   
         }
         
         calcularArea();  

         
      }
    
    
    
    }catch (exception) {
        console.error(exception)
    }

}




function pinSymbol(color) {
  return {
    path: icon2,
    fillColor: color,
    fillOpacity: 1,
    strokeColor: '#000',
    strokeWeight: 2,
    scale: 2,
    background:"black"
  };
}


function geocodeAddress(address) {
      console.log(address);
    
  var geocoder = new google.maps.Geocoder();
  
  geocoder.geocode({'address': address}, function(results, status) {
    if (status === google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var latlng = results[0].geometry.location;
        showMarkerView(latlng.lat(),latlng.lng());
    } else {
      geoCodingError('Geocode was not successful for the following reason: ' + status);
    }
  });
}

function geoCodingError(mensaje){
    $("#mensaje").text(mensaje);
    PF("dialogGeocoding").show();
}

function showStreeView(lat,log){
    createMap();
    console.log(lat+":"+log);
    
     fenway={lat: lat, lng: log};
     panorama = new google.maps.StreetViewPanorama(
      document.getElementById('pano'), {
        position:{lat: lat, lng: log},
        pov: {
          heading: 34,
          pitch: 10
        }
      });
      map.setCenter({lat: lat, lng: log});
      map.setStreetView(panorama);
      
      panorama.addListener("position_changed", function (e){
          fenway=this.getPosition();          
          document.getElementById("positionStreet").value=this.getPosition().lat()+","+this.getPosition().lng();
      });
      
     PF('dialostreetmap').show();
}


function showMarkerView(lat,lng){
    fenway={lat: lat, lng: lng};
    
    MarkerSuelo =new google.maps.Marker({
        position: fenway,
        map: map,
        draggable: true
      });
       
   
    map.setCenter(fenway);
      
      MarkerSuelo.addListener("position_changed", function (e){
          console.log(this.getPosition().lat()+","+this.getPosition().lng());
          fenway=this.getPosition();          
          document.getElementById("positionMarkerInfo").value=this.getPosition().lat()+","+this.getPosition().lng();
      });
}

function hideMarkerView(){
    MarkerSuelo.setMap(null);
}

function hideStreeView(){
    panorama.setVisible(false);
}

function reloadMap(){
    createMap();
    try{
        for (i=0;collection.length;i++){
            PF('gmap').addOverlay(collection[i]);
            PF('gmap').addOverlay(Polys[i]);
        }
    }catch (exception) {}

     try{map.setStreetView(panorama);}catch (exception) {}
     try{
        PF('gmap').addOverlay(MarkerSuelo);
         
       
         
    }catch (exception) {}
   
    
    if(activarmedir){
        if(listener1!=null)
            listener1 = map.addListener('click', addMarker);
     }
     
}


function mapZoomIn(type,cursor){
      map.setOptions({draggableCursor:cursor});
      google.maps.event.removeListener(listenerLupa);
      switch (type){
          case 1:
              listenerLupa= map.addListener("click",function(event){
                if(map.getZoom()<=20){  
                    map.setCenter(event.latLng);
                    let i=map.getZoom()+1;
                    console.log(i)
                    map.setZoom(i);
                }
               });
            break;
          case 2:
              listenerLupa= map.addListener("click",function (event){
                if(map.getZoom()>=1){  
                    map.setCenter(event.latLng);
                    let i=map.getZoom()-1;
                    console.log(i)
                    map.setZoom(i);
                }
               });
            break;
      
      }
}

function mapZoom(zoom){
    map.setZoom(zoom);
}


var printMap = function() {
    var content = window.document.getElementById("formmap"); // get you map details
    var newWindow = window.open(); // open a new window
    newWindow.document.write(content.innerHTML); // write the map into the new window
    newWindow.print();
};


function saveMapToDataUrl() {
    PF('statusDialog2').show();
    
    
    var w = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;

    var h = window.innerHeight
    || document.documentElement.clientHeight
    || document.body.clientHeight;
    
   var element= $('body,html');
    
    html2canvas(element.css({width:880}), {
        useCORS: true,
        onrendered: function (canvas) {
            var data = canvas.toDataURL('image/png');
            var image = new Image();
            image.src = data;
            image.width = 900;
            image.height  = 400;
            
            $('#imagenMap').html(image);
            PF('statusDialog2').hide();
            PF('dialogImg').show();
        },
        width:w,
        height:h
     });
}


            