
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const itemCode = urlParams.get('itemCode');
var content = document.querySelector(".product");





const url = 'http://localhost:8080/api/1.0/evlilik/teklifi/dekorlar/' + itemCode;




var getmasaDekor = function () {

    fetch(url, {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
            'X-Content-Type-Options': 'nosniff',
            "Access-Control-Allow-Headers": "Content-Type, Authorization, X-Requested-With",
            'Access-Control-Allow-Origin': '*'

        }
    })
        .then(res =>

            res.json(),

        )
        .then(data => {
            let img = null;
            if(data.cover_img !=null){
             img = data.cover_img.split("/", 6)[5];
            }

            content.innerHTML += `
              <div class="main-contain-summary">
              <div class="contain-left has-gallery">
                  <div class="single-left">
                      <div class="agch-product-gallery agch-product-gallery--with-images agch-product-gallery--columns-4 images">
                          <div class="flex-viewport">
                              <figure class="agch-product-gallery__wrapper">
                    
                                 <div class="agch-product-gallery__image">
                                      <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">
                                  </div>
                                  <div class="agch-product-gallery__image">
                                      <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">
                                  </div>
                                <div class="agch-product-gallery__image">
                                      <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">

                                  </div>
                                  <div class="agch-product-gallery__image">
                                      <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">

                                  </div>


                      </figure>
                          </div>
                          <ol class="flex-control-nav flex-control-thumbs">
                                                                      <li>
                                  <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">
                              </li>
                                                                      <li>
                                  <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">
                              </li>
                                                                      <li>
                                  <img alt="img" src="https://drive.google.com/uc?export=view&id=${img}">
                              </li>
                              </li>
                              <li>
                                    <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">
                               </li>
                                <li>
                                    <img alt="${data.title}" src="https://drive.google.com/uc?export=view&id=${img}">
                                </li>


                               </ol>
                      </div>

                  </div>
                  <div class="summary entry-summary">
                      <h1 class="product_title entry-title">${data.title}</h1>
                      <div class="mt-2">
                          <span style="font-size: 15px;">Məhsul kodu: ${data.itemCode}</span>
                      </div>
          
                      <div class="agch-product-details__short-description">
                          <p>
                          ${data.description}</p>
                      </div>
                      
                      <div class="clear"></div>
                      <span>qiymət:</span>
                      <p class="price">
      
                          
                          <span class="agch-Price-amount amount">
                              <span class="agch-Price-amount amount">${data.price}<span class="agch-Price-currencySymbol">₼</span></span>                                    </span>
                     
                              
                          <a class="info-btn"  href="../../sertler-ve-qaydalar.html">Çatdırılma və ödəniş</a>                               
                      </p>

              

                
                 
                  </div>
              </div>
          </div>
                
                `;




        }

        );


}
getmasaDekor();

{/* <div class="agch-product-details__short-description">
<span>minimal sifariş ${data.guest_count} nəfər</span> <br>
</div> */}

















