import * as formControl from './controllers/form-controller.js';
import * as listControl from './controllers/list-controller.js';

formControl.init();
listControl.init();

// const name = ' ';
//
// let url = 'http://localhost:8080/users/find-by-name?';
//
// const fetchResult = fetch(url);
//
// fetchResult
//     .then(response => {
//         console.log("SUCESSO NO FETCH", response);
//         const json = response.json();
//         json
//             .then(result => {
//             console.log("SUCESSO NO JSON", result);
//         })
//             .catch(error => {
//             console.log("ERRO O JSON", error);
//         });
//     })
//     .catch(error => {
//        console.log("ERRO NO FETCH", error);
//     });