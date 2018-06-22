
function buscaInfo() {
	$("#spinner").toggle();
	let codigo = $("#codigo").val();
	$.ajax({
		type : "GET",
		url : "/recebimento/buscaInfoRecebimento/" + codigo
	}).done(function(estoque) {
		
		reagent = jQuery.parseJSON(estoque);
		console.log("endereco: " +reagent);
		console.log("teste");
		
		if(reagent === null){
			$("#mensagem").html("Produto não disponível <a href='/estoque/form'>Clique aqui</a> para cadastrar um novo produto");
			$("#mensagem").addClass( "alert alert-danger" );
			document.getElementById('descricao').value = "";
			document.getElementById('endereco').value = "";
		}else{
			$("#mensagem").removeClass("alert alert-danger");
			$("#mensagem").html("");
			document.getElementById('descricao').value = reagent.descricao;
			document.getElementById('endereco').value = reagent.endereco;
		}
		
		
//		document.getElementById('descricao').value = reagent.descricao;
		
//		document.getElementById('endereco').value = reagent.endereco;
//		if(reagent.descricao == null){
//			$("#mensagem").html("Reagente n�o dispon�vel no site da cetesb");
//			$("#mensagem").addClass( "alert alert-danger" );
//			alert("N�o encontrado");
//		}else{
//			alert("Sucesso" + reagente.descricao);
//		}
//			$("#mensagem").removeClass("alert alert-danger");
//			$("#mensagem").html("");
//			document.getElementById('formula').value = reagent.formula;
//			document.getElementById('massaMolar').value = reagent.massaMolar;
//			document.getElementById('familia').value = reagent.familia;
//			document.getElementById('aparencia').value = reagent.aparencia;
//			document.getElementById('link').value = reagent.link;
//			document.getElementById('ph').value = reagent.ph;
//			document.getElementById('perigoSaude').value = reagent.perigoSaude;
//			document.getElementById('reatividade').value = reagent.reatividade;
//			document.getElementById('estabilidade').value = reagent.estabilidade;
//			document.getElementById('armazenamento').value = reagent.armazenamento;
//			document.getElementById('parametroIndicacao').value = reagent.parametroIndicacao;
//			document.getElementById('metodoPreparo').value = reagent.metodoPreparo;
//			document.getElementById('indicacaoRevalidacao').value = reagent.indicacaoRevalidacao;
//			document.getElementById('compostoDescarte').value = reagent.compostoDescarte;
//			document.getElementById('metodoDescarte').value = reagent.metodoDescarte;
//		}
	})
	.always(function(){ //sempre escondendo o spinner
        $("#spinner").toggle();
    });
	
}