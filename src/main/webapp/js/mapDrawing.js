

var drawingManager = new google.maps.drawing.DrawingManager();
var colorfill='#6c6c6c';
var strokeWeights= 3;
var fillOpacity= 60;


$(function()
    {
       
            $('#txt2').change(
			function()
			{
				 alert($("#txt2").val());
				
			}
		);
        
        
    });

function drawRec(data) {
    
    
    console.log(colorfill);
    
    console.log(strokeWeights);
    
    console.log(fillOpacity);
    
		//Setting options for the Drawing Tool. In our case, enabling Polygon shape.
		drawingManager.setOptions({
			drawingMode : data,
			drawingControl : false,
			drawingControlOptions : {
				position : google.maps.ControlPosition.TOP_CENTER,
				drawingModes : [ google.maps.drawing.OverlayType.RECTANGLE,google.maps.drawing.OverlayType.CIRCLE ]
			},
			rectangleOptions : {
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
              draggable: true
			},circleOptions: {
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
              draggable: true
			},polylineOptions:{				
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
               draggable: true
			},polygonOptions:{				
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
               draggable: true
		   }
				
		});
		// Loading the drawing Tool in the Map.
		drawingManager.setMap(map);
}

function changeDrawing(){
    drawingManager.setOptions({
			drawingControl : false,
			rectangleOptions : {
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
              draggable: true
			},circleOptions: {
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
              draggable: true
			},polylineOptions:{				
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
               draggable: true
			},polygonOptions:{				
				strokeColor : colorfill,
				strokeWeight : strokeWeights,
				fillColor : colorfill,
				fillOpacity : fillOpacity/100,
                editable: true,
               draggable: true
		   }
				
		});
    
}

function colorfills(){
    colorfill=$("#bau").val();
    console.log($("#bau").val());
    changeDrawing();
}

function opacity(){
    fillOpacity = $("#txt2").val();
    console.log($("#txt2").val());
    changeDrawing();
}

function strokeWeight(){
    strokeWeights = $("#txt3").val();
    console.log($("#txt3").val());
    changeDrawing();
}





function none() {
		drawingManager.setMap(null);
}
