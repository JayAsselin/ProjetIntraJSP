function fnBuy(isbn) {
    fetch(`http://localhost:8080/listeLivres/acheter/${isbn}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(response.status);
            }
            return response.text();
        })
        .then(data => {
            let item = document.getElementById('items');
            item.textContent = data;
            document.getElementById(isbn).style.visibility="hidden";
        })
        .catch(err => console.log(err));
};

function fnDelete(isbn, name) {
    if (confirm(`Voulez-vous vraiment supprimer ${name}?`)) {
        fetch(`http://localhost:8080/panier/supprimer/${isbn}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(response.status);
                }
                return response.text();
            })
            .then(data => {
                let item = document.getElementById(isbn);
                item.remove();
                alert(data);
            })
            .catch(err => console.log(err));
    }
}