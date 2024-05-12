function get(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return JSON.parse(request.responseText);
}

function adicionarLinhas(){
    var data = get("http://localhost:8080/mostrarchamados");
    var linhas = "";
    var i = 0;
    for(i = 0; i < data.length; i++){
        linhas += '<tr class="font-['+'Quicksand'+'] items-center no-wrap mx-5 text-xs mt-5 px-5 gap-12 flex justify-between text-[#B9375E] bg-[#FFE0E9] rounded-md h-8 w-8/8">'
                        + '<td><button class="font-['+'Quicksand'+'] font-bold mr-5 bg-[#800E13] hover:bg-[#38040E] active:bg-[#800E13] focus:outline-none focus:ring rounded-md text-white py-1 px-2 mt-1">'+'X'+'</button></td>'
                        +'<td><button class=" font-['+'Quicksand'+'] bg-green-700 hover:bg-green-900 active:bg-green-800 focus:outline-none focus:ring text-1xl mt-1 rounded-md p-1 px-2 font-bold text-white">'+'EDITAR'+'</button></td>'
                        + '<td>'+ data[i].titulo + '</td>'
                        + '<td class="truncate bg-white rounded-md">'+ data[i].prioridade + '</td>'
                        + '<td>'+ data[i].dataInicio + '</td>'
                        + '<td class="truncate bg-white rounded-md">'+ data[i].usuario.setor.nome + '</td>'
                        + '<td class="truncate bg-white rounded-md">' + 'aguardando técnico' + '</td>'
                        + '</tr>'


    }
    document.getElementById("table").innerHTML = linhas;
}