const getProducts = () => {
    return fetch('/api/products')
        .then(response => response.json())
        .catch(error => console.log(error));
}

const handleAddToBasket = (productId) => {
    const url = `/api/add-product/${productId}`;
    return fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
    });
}

const refreshCurrentOffer = () => {
    return fetch('/api/current-offer')
        .then(r => r.json())
        .then(offer => updateBasketComponent(offer))
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

const appendToProductList = (htmlList, htmlElements) => {
    htmlElements.forEach(element => htmlList.appendChild(element));

    return htmlElements;
}



/*@TODO i don't like it */
const updateBasketComponent = (offer) => {
    const basketEl = document.querySelector('.basket');
    basketEl.querySelector('.basket__items-count').innerText = `${offer.linesCount} Items`;
    basketEl.querySelector('.basket__total').innerText = `${offer.total} PLN`;
}


const initializeAddToBasketHandler = (htmlElements) => {
    htmlElements.forEach(element => {
        const addToBasketBtn = element.querySelector('.product__add-to-basket');

        addToBasketBtn.addEventListener('click', (event) => {
            const productId = event.target.getAttribute('data-product-id');
            handleAddToBasket(productId)
                .then(() => refreshCurrentOffer())
                .catch((err) => console.log('something is not YES :>'))
        });
    })
    return htmlElements;
}

(() => {
    console.log("It works :):)");
    const productsList = document.querySelector('.products__list');
    const buyBtn = document.getElementById('buy');

    buyBtn.addEventListener('click', () => {
        console.log('accept offer needs to be implemented');
    })

    refreshCurrentOffer()
        .then(() => console.log('offer should be refreshed'));

    getProducts()
        .then(productsAsJsonObject => productsAsJsonObject.map(createProductComponent))
        .then(productsAsHtmlEl => initializeAddToBasketHandler(productsAsHtmlEl))
        .then(productsAsHtmlEl => appendToProductList(productsList, productsAsHtmlEl))

})();
