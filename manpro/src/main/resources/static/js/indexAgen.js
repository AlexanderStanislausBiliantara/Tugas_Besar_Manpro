(function () {
    const lantai = document.getElementById('lantai-field');
    const searchButton = 

    lantai.addEventListener('input', function (){
        const value = lantai.value;
        if(value <= 0){
            this.value = "";
        }
        else if(value > 20){
            this.value = 20;
        }
    })
})();