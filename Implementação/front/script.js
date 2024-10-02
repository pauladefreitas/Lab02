document.getElementById('rental-form').addEventListener('submit', async function(event) {
    event.preventDefault();

    const cliente = document.getElementById('cliente').value;
    const veiculo = document.getElementById('veiculo').value;
    const dataInicio = document.getElementById('dataInicio').value;
    const dataFim = document.getElementById('dataFim').value;
    const valor = document.getElementById('valor').value;

    const rentalData = {
        cliente: cliente,
        veiculo: veiculo,
        dataInicio: dataInicio,
        dataFim: dataFim,
        valor: valor
    };

    try {
        const response = await fetch('http://localhost:8080/api/pedidoAluguel', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(rentalData)
        });

        if (response.ok) {
            alert('Pedido de aluguel cadastrado com sucesso!');
        } else {
            alert('Erro ao cadastrar o pedido de aluguel.');
        }
    } catch (error) {
        console.error('Erro ao enviar dados para a API:', error);
        alert('Erro ao cadastrar o pedido de aluguel.');
    }
});