function Get(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return JSON.parse(request.responseText);
}

function main(){
let arr = Get("http://localhost:8080/mostrarchamados");
    var i;
    for(i = 0; i < arr.length; i++) {
        document.getElementById("titulo").innerHTML = arr[i].titulo;
        document.getElementById("prioridade").innerHTML = '<option value="' + arr[i].prioridade + '">' + arr[i].prioridade + '</option>'
        document.getElementById("data").innerHTML = arr[i].dataInicio;
        document.getElementById("setor").innerHTML = '<option value="' + arr[i].usuario.setor.id + '">' + arr[i].usuario.setor.nome + '</option>';
        document.getElementById("status").innerHTML = "aguardando tecnico";
    }
}

