$( document ).ready(function() {
    
    var map = L.map('map', {
        center: [40.45073840670121, 49.865417938698954],
        tap: false,
        zoom: 10,
        scrollWheelZoom: false,
    });

    var osmUrl = 'https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png';
    var osmLayer = new L.TileLayer(osmUrl, {
        maxZoom: 19,
        attribution: 'Map data © OpenStreetMap contributors'
    });

    var redIcon = new L.Icon({
        iconUrl: 'https://agciceyim.az/template/design/assets/images/marker-icon-red.png',
        shadowUrl: 'https://agciceyim.az/template/design/assets/images/marker-shadow.png',
        iconSize: [25, 41],
        iconAnchor: [12, 41],
        popupAnchor: [1, -34],
        shadowSize: [41, 41]
    });

    map.addLayer(osmLayer);

    var markers = [
    
        L.marker([40.483, 49.760],{title:"Masazır", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Masazır</h4><p>Oba marketin yanı</p><div><a href='tel:+99477 314 50 46'></a></div><div><a href='tel:+99477 314 50 46'>+99477 314 50 46</a></div></div>"),

    
  
        ];

    console.log(markers);

    function markerFunction(id){
        for (var i in markers){
            var markerID = markers[i].options.title;
            if (markerID == id){
                markers[i].openPopup();
            };
        }
    }


    $("#branches").on("change", function(){
        id = $("#branches option").filter(":selected").val();
        markerFunction(id);
    });

});