var baseUrl = "http://localhost:8080/";

function request(method, path, data){
    let request = new XMLHttpRequest();
    request.open(method, baseUrl + path, false);
    request.setRequestHeader('Content-Type', 'application/json');
    data ? request.send(JSON.stringify(data)) : request.send();
    const response = request.responseText;
    return response ? JSON.parse(request.responseText) : request.responseText;
}

function getChamadosUsuario(){
    var chamados = request( "GET", "mostrarchamados");
    var linhas = "";
    var i = 0;
    for(i = 0; i < chamados.length; i++){
    var data = new Date(chamados[i].dataInicio);
    var dataFormatada = data.getDate() + '-' + (data.getMonth() + 1) + '-' + data.getFullYear();
    var rotaEditarChamado = "atualizar-chamado";
        linhas += '<tr id="'+chamados[i].id+'" class="font-['+'Quicksand'+'] items-center no-wrap mx-5 text-xs mt-5 px-5 gap-12 flex justify-between text-[#B9375E] bg-[#FFE0E9] rounded-md h-8 w-8/8">'
                        + '<td><button onclick="excluirChamado('+ chamados[i].id +')" class="font-['+'Quicksand'+'] font-bold mr-5 bg-[#800E13] hover:bg-[#38040E] active:bg-[#800E13] focus:outline-none focus:ring rounded-md text-white py-1 px-2 mt-1">'+'X'+'</button></td>'
                        +'<td><button OnClick=" location.href=' + "'" + rotaEditarChamado + "'" +'" class=" font-['+'Quicksand'+'] bg-green-700 hover:bg-green-900 active:bg-green-800 focus:outline-none focus:ring text-1xl mt-1 rounded-md p-1 px-2 font-bold text-white">'+'EDITAR'+'</button></td>'
                        + '<td>'+ chamados[i].titulo + '</td>'
                        + '<td class="truncate bg-white rounded-md">'+ chamados[i].prioridade + '</td>'
                        + '<td>'+ dataFormatada + '</td>'
                        + '<td class="truncate bg-white rounded-md">'+ chamados[i].usuario.setor.nome + '</td>'
                        + '<td class="truncate bg-white rounded-md">' + 'aguardando técnico' + '</td>'
                        + '</tr>'


    }
    document.getElementById("table").innerHTML = linhas;
}

function excluirChamado(id){
    request( "DELETE", "excluirchamado/" + id);
    document.getElementById(id).remove();
}

function excluirCadastro(){
    //request( "DELETE", "excluirpessoa/" + id);
    location.href="login";
}

function cadastrarPessoa(formulario){
    const dadosFormulario = getFormData(formulario);
    request("POST", "pessoa/cadastrar", dadosFormulario);
    alert("Cadastro feito com sucesso!");
    window.location.href = '/login';
}

function logarPessoa(formulario){
    const dadosFormulario = getFormData(formulario);
    console.log(dadosFormulario);
    const response = request("POST", "pessoa/login", dadosFormulario);
    console.log(response);

    const aguardandoAutorizacao = response.tipo == "Aguardando Autorização";
    const loginMessage = aguardandoAutorizacao ? "Aguarde autorização do Admin!" : "Login feito com sucesso!"
    alert(loginMessage);

    if (aguardandoAutorizacao) {
        return;
    }

    localStorage.setItem("token", response.token);

    switch(response.tipo) {
        case 'Admin':
            window.location.href = '/admin';
            break;
        case 'Técnico':
            window.location.href = "tela-tecnico";
            break;
        case 'Usuário':
            window.location.href = '/tela-usuario';
            break;
        default:
            alert("Tipo de pessoa inválido!");
    }
}

function getFormData(form){
    const inputs = Array
         .from(form.children)
         .filter(el => el.tagName == 'INPUT' || el.tagName == 'SELECT')
         .map(el => [el.name, el.value]);

    return formData = Object.fromEntries(inputs);
}