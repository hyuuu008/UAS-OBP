
    document.getElementById("dinein").addEventListener("change", () => {
        document.getElementById("table-number").style.display = "block";
    });
    document.getElementById("takeaway").addEventListener("change", () => {
        document.getElementById("table-number").style.display = "none";
    });


    let cart = [];
    let total = 0;

    function addItem(name, price) {
        let existing = cart.find(item => item.name === name);

        if (existing) {
            existing.qty++;
        } else {
            cart.push({ name, price, qty: 1 });
        }

        updateCartDisplay();
    }

  
    function updateCartDisplay() {
        let list = document.getElementById("cart-list");
        list.innerHTML = "";
        total = 0;

        cart.forEach((item, index) => {
            total += item.price * item.qty;

            let li = document.createElement("li");
            li.classList.add("list-group-item", "d-flex", "justify-content-between");

            li.innerHTML = `
                <span>${item.name} - Rp ${item.price} x ${item.qty}</span>
                <button class="btn btn-danger btn-sm" onclick="removeItem(${index})">Hapus</button>
            `;

            list.appendChild(li);
        });

        document.getElementById("total").innerText = total;
    }

 
    function removeItem(index) {
        cart.splice(index, 1);
        updateCartDisplay();
    }


 
    document.querySelectorAll(".add-btn").forEach(btn => {
        btn.addEventListener("click", () => {
            const name = btn.dataset.nama;
            const price = parseInt(btn.dataset.harga);
            addItem(name, price);
        });
    });


    function goToKasir() {
        if (cart.length === 0) {
            alert("Keranjang masih kosong!");
            return;
        }

        let service = document.querySelector('input[name="service"]:checked');
        if (!service) {
            alert("Pilih layanan dulu!");
            return;
        }

        if (service.value === "Dine In") {
            let meja = document.getElementById("meja").value;
            if (meja.trim() === "") {
                alert("Masukkan nomor meja!");
                return;
            }
            sessionStorage.setItem("nomorMeja", meja);
        }

   
        sessionStorage.setItem("tipePesanan", service.value);
        sessionStorage.setItem("cart", JSON.stringify(cart));
        sessionStorage.setItem("total", total);

        window.location.href = "/kasir";
    }

