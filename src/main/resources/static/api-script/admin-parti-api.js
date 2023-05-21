
const form = document.getElementById('form');
const url = 'http://localhost:8080/api/1.0/partidekorlar';
let img_data = '';

// function readFile(input) {
//   let file = input.files[0];

  
//   let reader = new FileReader();

//   reader.readAsDataURL(file);

//   reader.onload = function () {
//     img_data = reader.result.split(',')[1];
//   };


//   reader.onerror = function () {
//     console.log(reader.error);
//   };


// }



form.addEventListener('submit', function (e) {
  e.preventDefault();

  var payload = new FormData(form)
  // payload.append("cover_img", img_data);

  var data = Object.fromEntries(payload);

  console.log([...payload]);
  console.log(data);


  fetch(url, {
    method: 'POST',
    headers: new Headers({ 'Content-Type': 'application/json' }),
    body: JSON.stringify(data)
  }
  )
    .then(res => res.json())
    .then(data => console.log(data))
    .catch(err => console.log(err));


})


















