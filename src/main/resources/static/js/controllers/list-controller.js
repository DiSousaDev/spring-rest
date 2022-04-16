import * as userService from '../services/UserService.js';

function State() {
    this.listSection = null;
}

const state = new State();

export function init() {
    state.listSection = document.querySelector("#list-section");
    addList();
}

export function addList() {
    const list = createList();
    state.listSection.appendChild(list);
}

async function getUsers() {
    return await userService.findAll();
}

function createList(user) {


    // <table className="table">
    //     <thead>
    //     <tr>
    //         <th scope="col">Id</th>
    //         <th scope="col">Nome</th>
    //         <th scope="col">Idade</th>
    //     </tr>
    //     </thead>
    //     <tbody>
    //     <tr>
    //         <th scope="row">1</th>
    //         <td>Mark</td>
    //         <td>45</td>
    //     </tr>
    //     <tr>
    //         <th scope="row">2</th>
    //         <td>Jacob</td>
    //         <td>33</td>
    //     </tr>
    //     <tr>
    //         <th scope="row">3</th>
    //         <td>Larry the Bird</td>
    //         <td>21</td>
    //     </tr>
    //     </tbody>
    // </table>


    const div = document.createElement("table");
    div.classList.add("table");

    const thead = document.createElement("thead");
    const tr = document.createElement("tr");
    const th1 = document.createElement("th");
    th1.scope = "col";
    th1.innerText = "Id";
    const th2 = document.createElement("th");
    th2.scope = "col";
    th2.innerText = "Nome";
    const th3 = document.createElement("th");
    th3.scope = "col";
    th3.innerText = "Idade";

    const tbody = document.createElement("tbody");


    // const h3 = document.createElement("h3");
    // h3.innerHTML = endereco.cidade;
    //
    // const line = document.createElement("p");
    // line.classList.add("end-rua");
    // line.innerHTML = `${endereco.logradouro}, ${endereco.numero}`;
    //
    // const cep = document.createElement("p");
    // cep.classList.add("end-cep");
    // cep.innerHTML = endereco.cep;
    //
    div.appendChild(thead);
    thead.appendChild(tr);
    tr.appendChild(th1);
    tr.appendChild(th2);
    tr.appendChild(th3);
    div.appendChild(tbody);

    return div;

}