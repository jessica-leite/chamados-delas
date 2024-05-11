function Get(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function main(){
    console.log(Get("http://localhost:8080/mostrarsetores"))
}

main();