function State() {
    this.btnSalvar = null;

    this.inputId = null;
    this.inputNome = null;
    this.inputIdade = null;
}

const state = new State();

export function init() {

    state.inputId = document.forms.formUser.id;
    state.inputNome = document.forms.formUser.nome;
    state.inputIdade = document.forms.formUser.idade;

    state.btnSalvar = document.forms.formUser.btnSalvar;

}