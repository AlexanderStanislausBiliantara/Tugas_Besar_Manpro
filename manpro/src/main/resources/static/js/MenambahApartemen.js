function openPopUp(){
    document.getElementById('popup').style.display = 'flex';
}

function closePopUp() {
    document.getElementById('popup').style.display = 'none';
}

function addUnit(){
    const unit = document.getElementById('new-unit');
    const newUnit = unit.cloneNode(true);
    newUnit.style.display = 'flex';
    document.getElementById('result_container').appendChild(newUnit);

    // const tower = document.getElementById('tower').value;
    // let lantai = document.getElementById('noLantai').value;
    // let noUnit = document.getElementById('noUnit').value;
    // const harga = document.getElementById('tarif').value;
    // const tipeUnit = document.getElementById('tipe').value;

    // let kodeUnit = tower;

    // if(lantai<10){
    //     kodeUnit = kodeUnit+'0'+lantai;
    // }
    // else{
    //     kodeUnit = kodeUnit+lantai;
    // }

    // if(noUnit<100){ 
    //     kodeUnit = kodeUnit+'0'+noUnit;
    // }
    // else{
    //     kodeUnit = kodeUnit+noUnit;
    // }


    // document.getElementById('kode-unit').textContent = kodeUnit;
    // document.getElementById('tower-unit').textContent   = tower;
    // document.getElementById('lantai').textContent   = lantai;
    // document.getElementById('no-unit').textContent  = noUnit;
    // document.getElementById('harga-unit').textContent   = harga;
    // document.getElementById('tipe-unit').textContent    = tipeUnit;
}

(function(){
    const lantai = document.getElementById('noLantai');
    const noUnit = document.getElementById('noUnit');

    lantai.addEventListener('input', function(){
        const valueLantai = lantai.value;
        if(valueLantai <= 0){
            this.value = "";
        }
        else if(valueLantai > 20){
            this.value = 20;
        }

    });

    noUnit.addEventListener('input', function(){
        const valueUnit = noUnit.value;
        if(valueUnit<=0){
            this.value = "";
        }
        else if(valueUnit>200){
            this.value = 200;
        }

    })
})();



