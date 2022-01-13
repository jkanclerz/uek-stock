const getProducts = () => {
    return fetch('/api/products')
        .then(response => response.json())
        .catch(error => console.log(error));
}

const createHtmlElementFromString = (htmlAsString) => {
    let myElement = document.createElement('div');
    myElement.innerHTML = htmlAsString.trim();

    return myElement.firstChild;
}

const createProductComponent = (product) => {
    const template = `
        <li class="product">
            <h3>${product.title}</h3>
            <div class="product__image">
                <img src="${product.mediaPath}" />
            </div>
            <span class="product__price">${product.price}</span>
            <button
                class="product__add-to-basket"
                data-product-id="${product.id}"
            >Add to basket</button>
        </li>
    `;

    return createHtmlElementFromString(template);
}

(() => {
    console.log("It works :):)");

    getProducts()
        .then(productsAsJsonObject => productsAsJsonObject.map(createProductComponent))
        .then(productsAsHtml => console.log(productsAsHtml))
        //json -> html

})();
