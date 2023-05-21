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
        L.marker([40.39559592944799, 49.83991132787222],{title:"Baş filial", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Главный филиал</h4><p>пр. Азадлыг 191 E</p><div><a href='tel:+99450 212 21 21'>+99450 212 21 21</a></div><div><a href='tel:+99450 600 50 50'>+99450 600 50 50</a></div></div>"),

        L.marker([40.36808774246433, 49.81663259777714],{title:"Elmlər Akademiyası", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Эльмляр</h4><p>пр. Гусейн Джавид 19</p><div><a href='tel:+99450 221 21 71'>+99450 221 21 71</a></div><div><a href='tel:+99412 539 92 29'>+99412 539 92 29</a></div></div>"),

        L.marker([40.39817669051351, 49.95293945927108],{title:"Xalqlar Dostluğu", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Халглар</h4><p>возле станции метро Халглар достлугу</p><div><a href='tel:+99450 455 21 21'>+99450 455 21 21</a></div><div><a href='tel:+99412 375 32 30'>+99412 375 32 30</a></div></div>"),

        L.marker([40.380950212900125, 49.83046057643654],{title:"Nizami", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Низами</h4><p>Джафар Джаббарлы 16 <br>возле станции метро Низами</p><div><a href='tel:+99450 212 21 21'>+99450 212 21 21</a></div><div><a href='tel:+99450 600 50 50'>+99450 600 50 50</a></div></div>"),

        L.marker([40.403249580686115, 49.87177001477279],{title:"Nəriman Nərimanov", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Нариман Нариманов</h4><p>пересечение ул. Ага Нейматулла и ул. Табриз</p><div><a href='tel:+99450 403 22 12'>+99450 403 22 12</a></div><div><a href='tel:+99412 566 91 71'>+99412 566 91 71</a></div></div>"),

        L.marker([40.38901929030877, 49.83489023480997],{title:"Bakıxanov prospekti", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Бакиханов</h4><p>пр. Бакиханова 29<br> возле посольства РФ</p><div><a href='tel:+99450 303 21 21'>+99450 303 21 21</a></div><div><a href='tel:+99412 596 63 33'>+99412 596 63 33</a></div></div>"),

        L.marker([40.41694014921093, 49.93854416577812],{title:"Qara Qarayev", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Гара Гараев</h4><p>пр. Гара Гараева 37A</p><div><a href='tel:+99450 656 21 21'>+99450 656 21 21</a></div><div><a href='tel:+99470 856 21 21'>+99470 856 21 21</a></div></div>"),

        L.marker([40.30327486251590, 49.75951723673904],{title:"Binə t/m", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>т/ц Бина</h4><p>торговый центр Бина (Вход)</p><div><a href='tel:+99450 600 21 21'>+99450 600 21 21</a></div></div>"),

        L.marker([40.3678935658638, 49.83160764010547],{title:"İçərişəhər", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Ичери-шехер</h4><p>ул. Истиглалият 57</p><div><a href='tel:+99450 777 72 77'>+99450 777 72 77</a></div><div><a href='tel:+99412 492 80 79'>+99412 492 80 79</a></div></div>"),

        L.marker([40.4512102920279, 49.744068097917996],{title:"Xırdalan", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Хырдалан</h4><p>напротив парка Гейдара Алиева</p><div><a href='tel:+99450 454 21 21'>+99450 454 21 21</a></div><div><a href='tel:+99455 267 88 00'>+99455 267 88 00</a></div></div>"),

        L.marker([40.34335929237593, 49.81013968882109],{title:"Badamdar", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Бадамдар</h4><p>Бадамдарское шоссе 105 <br>Массив 1, 5/7</p><div><a href='tel:+99450 800 21 21'>+99450 800 21 21</a></div></div>"),

        L.marker([40.42055063806068, 49.9630469979171],{title:"Bakıxanov qəsəbəsi", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>пос. Бакиханов</h4><p>пр. С. Мехмандарова</p><div><a href='tel:+99450 444 21 21'>+99450 444 21 21</a></div><div><a href='tel:+99412 428 24 08'>+99412 428 24 08</a></div></div>"),

        L.marker([40.44036572778645, 49.98597339791765],{title:"Bülbülə", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Бюльбюля</h4><p>Аэропортовское шоссе <br>пр. Гейдара Алиева 320a</p><div><a href='tel:+99450 600 15 15'>+99450 600 15 15</a></div></div>"),

        L.marker([40.38073122583597, 49.84661244024402],{title:"28 Express", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>28 Express</h4><p>пересечение ул. Сулеймана Рагимова и пр. Азадлыг</p><div><a href='tel:+99455 550 20 40'>+99455 550 20 40</a></div><div><a href='tel:+99412 440 2040'>+99412 440 2040</a></div></div>"),

        L.marker([40.38098520684924, 49.88117599791588],{title:"Ağ Şəhər", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Аг Шехер</h4><p>ул. Хагани Рустамова 2110 <br>Yaşıl ada 1</p><div><a href='tel:+99412 525 01 25'>+99412 525 01 25</a></div><div><a href='tel:+99450 271 11 00'>+99450 271 11 00</a></div></div>"),

        L.marker([40.39050611099823, 49.95394966908022],{title:"Əhmədli", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Ахмедлы</h4><p>ул. М. Хади 136</p><div><a href='tel:+99410 212 20 20'>+99410 212 20 20</a></div><div><a href='tel:+99410 212 20 21'>+99410 212 20 21</a></div></div>"),

        L.marker([40.40481497626699, 49.80329654024482],{title:"20 Yanvar", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>20 января</h4><p>ул. Шарифзаде 443</p><div><a href='tel:+99410 215 12 12'>+99410 215 12 12</a></div></div>"),

        L.marker([40.38516229620677, 49.85401294024409],{title:"Yaşıl bazar", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Зеленый Базар</h4><p>пр. Хатаи 21A</p><div><a href='tel:+99410 710 12 12'>+99410 710 12 12</a></div><div><a href='tel:+99499 710 12 12'>+99499 710 12 12</a></div></div>"),

        L.marker([40.38516229620677, 49.85401294024409],{title:"Xətai", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Хатаи</h4><p>ул. Афияддина Джалилова 4б</p><div><a href='tel:+99470 354 06 06'>+99470 354 06 06</a></div><div><a href='tel:+99410 310 21 21'>+99410 310 21 21</a></div></div>"),

        L.marker([40.59261085459516, 49.67401196908634],{title:"Sumqayıt", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Сумгаит</h4><p>пр. Н. Нариманова 19</p><div><a href='tel:+99450 400 25 25'>+99450 400 25 25</a></div></div>"),

        L.marker([40.68837837988009, 46.36538006908931],{title:"Gəncə", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Гянджа</h4><p>пр. Гейдара Алиева 64a</p><div><a href='tel:+99450 435 50 70'>+99450 435 50 70</a></div><div><a href='tel:+99455 493 50 70'>+99455 493 50 70</a></div></div>"),

        L.marker([38.75454958113945, 48.85152194019537],{title:"Lənkəran", icon: redIcon})
            .addTo(map)
            .bindPopup("<div class='text-center'><h4>Ленкорань</h4><p>уо. Ази Асланова 50 <br>напротив Ленкоранского Государственного Университета</p><div><a href='tel:+99451 698 13 13'>+99451 698 13 13</a></div><div><a href='tel:+99450 563 20 02'>+99450 563 20 02</a></div><div><a href='tel:+99451 563 20 03'>+99451 563 20 03</a></div></div>"),
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