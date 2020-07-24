function starts(id){
    var xs=document.getElementById(id).getElementsByClassName("ui-fileupload-content");
    xs[0].style.display='block';
}

function stops(id){
   var xs=document.getElementById(id).getElementsByClassName("ui-fileupload-content");
    xs[0].style.display='none';
}