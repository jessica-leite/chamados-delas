var baseUrl = "http://localhost:8080/";

function request(method, path, data){
    let request = new XMLHttpRequest();
    request.open(method, baseUrl + path, false);
    request.setRequestHeader('Content-Type', 'application/json');
    try {
        data ? request.send(JSON.stringify(data)) : request.send();
        const response = request.responseText;
        return response ? JSON.parse(request.responseText) : request.responseText;
    } catch {
        alert(request.responseText);
    }
}

function getTabelasAdmin(){
    getChamadosTecnico();
    getTecnicosAguardandoAutorizacao();
    getSetoresAdmin();
}

function getSetoresAdmin(){
    var setores = request("GET", "mostrarsetores");
        var linhas = "";
        var rotaEditarSetor = "atualizar-setor"
        for(i = 0; i < setores.length; i++){
            linhas += '<tr id="'+setores[i].id+'" class="font-['+'Quicksand'+'] items-center no-wrap mb-3 mx-5 text-xs mt-5 px-5 gap-12 flex justify-between text-[#B9375E] bg-[#FFE0E9] rounded-md h-8 w-8/8">'
                                              + '<td><button onclick="excluirSetor('+ setores[i].id +')" class="font-['+'Quicksand'+'] font-bold mr-5 bg-[#800E13] hover:bg-[#38040E] active:bg-[#800E13] focus:outline-none focus:ring rounded-md text-white py-1 px-2 mt-1">'+'X'+'</button></td>'
                                              +'<td><button OnClick=" location.href=' + "'" + rotaEditarSetor + "'" +'" class=" font-['+'Quicksand'+'] bg-green-700 hover:bg-green-900 active:bg-green-800 focus:outline-none focus:ring text-1xl mt-1 rounded-md p-1 px-2 font-bold text-white">'+'EDITAR'+'</button></td>'
                                              + '<td>'+ setores[i].nome + '</td>'
                                              + '</tr>'
        }
        document.getElementById("table-setor").innerHTML = linhas;
}

function excluirSetor(id){
    request("DELETE", "excluirsetor/" + id);
    alert("Setor excluído!");
    document.getElementById(id).remove();
}

function getTecnicosAguardandoAutorizacao(){
    var tecnicosAguardando = request("GET", "pessoa/autorizartecnico");
    var linhas = "";
    for(i = 0; i < tecnicosAguardando.length; i++){
        linhas += '<tr id="'+tecnicosAguardando[i].id+'" class="font-['+'Quicksand'+'] items-center no-wrap mb-3 mx-5 text-xs mt-5 px-5 gap-12 flex justify-between text-[#B9375E] bg-[#FFE0E9] rounded-md h-8 w-8/8">'
                                          + '<td><button onclick="excluirCadastroId('+ tecnicosAguardando[i].id +')" class="font-['+'Quicksand'+'] font-bold mr-5 bg-[#800E13] hover:bg-[#38040E] active:bg-[#800E13] focus:outline-none focus:ring rounded-md text-white py-1 px-2 mt-1">'+'X'+'</button></td>'
                                          +'<td><button OnClick="aprovarTecnico(' + tecnicosAguardando[i].id + ')" class=" font-['+'Quicksand'+'] bg-green-700 hover:bg-green-900 active:bg-green-800 focus:outline-none focus:ring text-1xl mt-1 rounded-md p-1 px-2 font-bold text-white">'+'APROVAR'+'</button></td>'
                                          + '<td>'+ tecnicosAguardando[i].nome + '</td>'
                                          + '<td>'+ tecnicosAguardando[i].email + '</td>'
                                          + '</tr>'
    }
    document.getElementById("table-tecnico").innerHTML = linhas;
}

function aprovarTecnico(id){
    request("POST", "pessoa/autorizar/" + id);
    alert("Técnico autorizado com sucesso!");
    document.getElementById(id).remove();
}

function getChamadosUsuario(){
    var chamados = request( "GET", "mostrarchamados/" + localStorage.getItem("pessoaId"));
    var linhas = "";
    var i = 0;
    for(i = 0; i < chamados.length; i++){
    var data = new Date(chamados[i].dataInicio);
    var dataFormatada = data.getDate() + '-' + (data.getMonth() + 1) + '-' + data.getFullYear();
    var rotaEditarChamado = "atualizar-chamado";
        linhas += '<tr id="'+chamados[i].id+'" class="font-['+'Quicksand'+'] items-center no-wrap mb-3 mx-5 text-xs mt-5 px-5 gap-12 flex justify-between text-[#B9375E] bg-[#FFE0E9] rounded-md h-8 w-8/8">'
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
    document.getElementById("nomePessoa").innerHTML = localStorage.getItem("nome");
}

function excluirChamado(id){
    request( "DELETE", "excluirchamado/" + id);
    document.getElementById(id).remove();
}

function excluirPessoa(){
    console.log("entrei no excluir pessoa")
    const id = localStorage.getItem("pessoaId");
    request( "DELETE", "pessoa/excluir/" + id);
    localStorage.clear();
    location.href="/cadastro";
}

function excluirCadastroId(id){
    request( "DELETE", "pessoa/excluir/" + id);
    alert("Cadastro excluído!")
     document.getElementById(id).remove();
}

function cadastrarPessoa(formulario){
    const dadosFormulario = getFormData(formulario);
    request("POST", "pessoa/cadastrar", dadosFormulario);
    alert("Cadastro feito com sucesso!");
    window.location.href = '/login';
}
function atualizarPessoa(formulario){
    const dadosFormulario = getFormData(formulario);
    const id = localStorage.getItem("pessoaId");
    request("POST", "pessoa/atualizar/" + id, dadosFormulario);
    alert("Atualização feita com sucesso!");
    window.location.href = '/login';
}

function cadastrarChamado(formulario){
    console.log(formulario);
    const chamado = getFormData(formulario);
    console.log(chamado);
    request("POST", "cadchamado/" + localStorage.getItem("pessoaId"), chamado);
    alert("Cadastro feito com sucesso!");
    window.location.href = '/tela-usuario'
}

function logarPessoa(formulario){
    const dadosFormulario = getFormData(formulario);
    const response = request("POST", "pessoa/login", dadosFormulario);
    console.log(response);

    const aguardandoAutorizacao = response.tipo == "Aguardando Autorização";
    const loginMessage = aguardandoAutorizacao ? "Aguarde autorização do Admin!" : "Login feito com sucesso!"
    alert(loginMessage);

    if (aguardandoAutorizacao) {
        return;
    }

    localStorage.setItem("token", response.token);
    localStorage.setItem("nome", response.nome);
    localStorage.setItem("pessoaId", response.id);

    switch(response.tipo) {
        case 'Admin':
            window.location.href = '/administrador';
            break;
        case 'Técnico':
            window.location.href = "/tela-tecnico";
            break;
        case 'Usuário':
            window.location.href = '/tela-usuario';
            break;
        default:
            alert("Tipo de pessoa inválido!");
    }
}

function logout(){
    localStorage.clear();
    window.location.href = '/login';
}

function getFormData(form){
    const inputs = Array
         .from(form.children)
         .filter(el => el.tagName == 'INPUT' || el.tagName == 'SELECT')
         .map(el => [el.name, el.value]);

    return formData = Object.fromEntries(inputs);
}

function getChamadosTecnico(){
var chamados = request( "GET", "mostrarchamados");
    var linhas = "";
    var i = 0;
    for(i = 0; i < chamados.length; i++){
    var data = new Date(chamados[i].dataInicio);
    var dataFormatada = data.getDate() + '-' + (data.getMonth() + 1) + '-' + data.getFullYear();

        linhas += ' <tr class="font-['+'Quicksand'+'] items-center mb-3 no-wrap mx-5 text-xs mt-5 px-5 gap-12 flex justify-between text-[#B9375E] bg-[#FFE0E9] rounded-md h-8 w-8/8">'
                                                     + '<td>' + chamados[i].id + '</td>'
                                                     +'<td class="truncate">'+ chamados[i].titulo + '</td>'
                                                     +'<td>'
                                                     +    '<select class="rounded-md">'
                                                     +       '<option value="baixa">baixa</option>'
                                                     +        '<option value="media">média</option>'
                                                     +        '<option value="alta">alta</option>'
                                                     +    '</select>'
                                                     +'</td>'
                                                     +'<td>'+ dataFormatada + '</td>'
                                                     +'<td>'
                                                     +'    <select class="rounded-md">'
                                                     +'        <option value="informatica">informática</option>'
                                                     +'        <option value="rh">recursos humanos</option>'
                                                     +'        <option value="marketing">marketing</option>'
                                                     +'    </select>'
                                                     +'</td>'
                                                     +'<td>'
                                                     +'    <select class="rounded-md">'
                                                     +'        <option value="aguardando">aguardando técnico</option>'
                                                     +'        <option value="atendimento">em atendimento</option>'
                                                     +'        <option value="outrosetor">escalado para outro setor</option>'
                                                     +'        <option value="finalizado">finalizado</option>'
                                                     +'    </select>'
                                                     +'</td>'
                                                 +'</tr>';


    }
    document.getElementById("tableTecnico").innerHTML = linhas;
    document.getElementById("nomePessoa").innerHTML = localStorage.getItem("nome");;

}

function getSetores(){
    console.log("Entrei na função setor")
    var setores = request("GET", "mostrarsetores");
    var linhas = '<option value = ""></option>';
    for(i = 0; i < setores.length; i++){
        linhas += '<option value = "' + setores[i].id +'">' + setores[i].nome +'</option>';
    }
    document.getElementById("select-setor").innerHTML = linhas;
}

function getPrioridades(){
 var prioridades = request("GET", "prioridades");
 var linhas = "";
     for(i = 0; i < prioridades.length; i++){
         linhas += '<option value = "' + prioridades[i] +'">' + prioridades[i] +'</option>';
     }
     document.getElementById("select-prioridade").innerHTML = linhas;
     document.getElementById("nomePessoa").innerHTML = localStorage.getItem("nome");
}