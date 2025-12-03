

 
    let cart = JSON.parse(sessionStorage.getItem("cart")) || [];
    let total = parseInt(sessionStorage.getItem("total")) || 0;
    let tipe = sessionStorage.getItem("tipePesanan") || "";
    let meja = sessionStorage.getItem("nomorMeja") || "";
    let metode = sessionStorage.getItem("metodePembayaran") || "";

 
    document.getElementById("tipePesanan").innerText = tipe;
    document.getElementById("total").innerText = total;
    document.getElementById("metode").innerText = metode;

    if (meja !== "") {
        document.getElementById("mejaRow").style.display = "block";
        document.getElementById("nomorMeja").innerText = meja;
    }

 
    let table = document.getElementById("struk-table");
    table.innerHTML = "";

    cart.forEach(item => {
        let row = document.createElement("tr");

        let col1 = document.createElement("td");
        col1.textContent = item.name;

        let col2 = document.createElement("td");
        col2.textContent = "Rp " + item.price;

        row.appendChild(col1);
        row.appendChild(col2);
        table.appendChild(row);
    });

 
    if(metode === "Tunai") {
        let uangBayar = parseInt(sessionStorage.getItem("uangBayar")) || 0;
        let kembali = uangBayar - total;
        if(kembali < 0) kembali = 0;
        document.getElementById("kembalian").innerText = kembali;
        document.getElementById("kembalianRow").style.display = "block";
    }

