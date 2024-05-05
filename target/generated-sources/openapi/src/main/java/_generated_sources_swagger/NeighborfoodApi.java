/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package _generated_sources_swagger;

import br.com.techchallenge.fiap.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.model.ClienteRequest;
import br.com.techchallenge.fiap.model.Combo;
import br.com.techchallenge.fiap.model.Mimo;
import br.com.techchallenge.fiap.model.Pagamento;
import br.com.techchallenge.fiap.model.Pedido;
import br.com.techchallenge.fiap.model.Produto;
import br.com.techchallenge.fiap.neighborfood.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.validation.Valid;

import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T00:44:45.191036500-03:00[America/Sao_Paulo]")
@Validated
@Tag(name = "follow-up", description = "Acompanhar status do pedido")
public interface NeighborfoodApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /neighborfood/acompanhamento/{idpedido} : Procura o status de um pedido
     * Retorna o status de um pedido
     *
     * @param idpedido id do pedido (required)
     * @return successful operation (status code 200)
     *         or Id inválido (status code 400)
     *         or Pedido não encontrado (status code 404)
     */
    @Operation(
        operationId = "findOrderByIdOrder",
        summary = "Procura o status de um pedido",
        description = "Retorna o status de um pedido",
        tags = { "follow-up" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/acompanhamento/{idpedido}",
        produces = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponse> _findOrderByIdOrder(
        @Parameter(name = "idpedido", description = "id do pedido", required = true, in = ParameterIn.PATH) @PathVariable("idpedido") Long idpedido
    ) {
        return findOrderByIdOrder(idpedido);
    }

    // Override this method
    default  ResponseEntity<AcompanhamentoResponse> findOrderByIdOrder(Long idpedido) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"status\" : { \"comboList\" : [ null, null ], \"produtoList\" : [ { \"preco\" : 0.8008281904610115, \"nome\" : \"nome\", \"descricao\" : \"descricao\" }, { \"preco\" : 0.8008281904610115, \"nome\" : \"nome\", \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /neighborfood/painel/estoque : Gerencia produtos e categorias
     * Lista categorias
     *
     * @return Lista categorias disponíveis (status code 200)
     *         or Categoria inválida (status code 400)
     *         or Categorias não cadastradas (status code 404)
     */
    @Operation(
        operationId = "listCategory",
        summary = "Gerencia produtos e categorias",
        description = "Lista categorias",
        tags = { "stock" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista categorias disponíveis", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Combo.class))
            }),
            @ApiResponse(responseCode = "400", description = "Categoria inválida"),
            @ApiResponse(responseCode = "404", description = "Categorias não cadastradas")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/painel/estoque",
        produces = { "application/json" }
    )
    default ResponseEntity<Combo> _listCategory(
        
    ) {
        return listCategory();
    }

    // Override this method
    default  ResponseEntity<Combo> listCategory() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/login : Se cadastrar, logar
     * Identificação do cliente
     *
     * @param clienteRequest Identifica um cliente logado (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Operation(
        operationId = "login",
        summary = "Se cadastrar, logar",
        description = "Identificação do cliente",
        tags = { "login" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário logado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default Cliente _login(
        @Parameter(name = "ClienteRequest", description = "Identifica um cliente logado") @Valid @RequestBody(required = false) ClienteRequest clienteRequest
    ) {
        return login(clienteRequest);
    }

    // Override this method
    default Cliente login(ClienteRequest clienteRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });

        return null;
    }


    /**
     * GET /neighborfood/menu : Apresenta o menu com itens opcionais
     * menu de opções
     *
     * @return Apresenta os itens de menu (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "menu",
        summary = "Apresenta o menu com itens opcionais",
        description = "menu de opções",
        tags = { "menu" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Apresenta os itens de menu", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Combo.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/neighborfood/menu",
        produces = { "application/json" }
    )
    default ResponseEntity<Combo> _menu(
        
    ) {
        return menu();
    }

    // Override this method
    default  ResponseEntity<Combo> menu() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/pedido : Realizar um pedido
     * Fazer um  pedido
     *
     * @param pedido Cria um novo pedido (optional)
     * @return Pedido criado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "order",
        summary = "Realizar um pedido",
        description = "Fazer um  pedido",
        tags = { "order" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido criado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/pedido",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponse> _order(
        @Parameter(name = "Pedido", description = "Cria um novo pedido") @Valid @RequestBody(required = false) Pedido pedido
    ) {
        return order(pedido);
    }

    // Override this method
    default  ResponseEntity<AcompanhamentoResponse> order(Pedido pedido) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"status\" : { \"comboList\" : [ null, null ], \"produtoList\" : [ { \"preco\" : 0.8008281904610115, \"nome\" : \"nome\", \"descricao\" : \"descricao\" }, { \"preco\" : 0.8008281904610115, \"nome\" : \"nome\", \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/pagamento : Realiza o pagamento do pedido
     * Realiza pagamento
     *
     * @param pagamento  (required)
     * @return pagamento realizado com sucesso. (status code 200)
     *         or Id inválido (status code 400)
     *         or Pedido não encontrado (status code 404)
     */
    @Operation(
        operationId = "payment",
        summary = "Realiza o pagamento do pedido",
        description = "Realiza pagamento",
        tags = { "payment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "pagamento realizado com sucesso.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AcompanhamentoResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/pagamento",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<AcompanhamentoResponse> _payment(
        @Parameter(name = "Pagamento", description = "", required = true) @Valid @RequestBody Pagamento pagamento
    ) {
        return payment(pagamento);
    }

    // Override this method
    default  ResponseEntity<AcompanhamentoResponse> payment(Pagamento pagamento) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"status\" : { \"comboList\" : [ null, null ], \"produtoList\" : [ { \"preco\" : 0.8008281904610115, \"nome\" : \"nome\", \"descricao\" : \"descricao\" }, { \"preco\" : 0.8008281904610115, \"nome\" : \"nome\", \"descricao\" : \"descricao\" } ] } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param body Cria um novo cliente (optional)
     * @return Usuário logado (status code 200)
     *         or request inválida (status code 400)
     */
    @Operation(
        operationId = "register",
        summary = "Se cadastrar, logar",
        description = "Cria cliente",
        tags = { "register" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuário logado", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            }),
            @ApiResponse(responseCode = "400", description = "request inválida")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/cadastro",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Object> _register(
        @Parameter(name = "body", description = "Cria um novo cliente") @Valid @RequestBody(required = false) Object body
    ) {
        return register(body);
    }

    // Override this method
    default  ResponseEntity<Object> register(Object body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf(""))) {
                    String exampleString = "";
                    ApiUtil.setExampleResponse(request, "", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/painel/produto/cadastro : Cadastra produtos
     * Cadastra produtos a partir da uma categoria
     *
     * @param produto  (required)
     * @return Erro ao cadastrar (status code 200)
     *         or Id inválido (status code 400)
     *         or Produto inválido (status code 404)
     */
    @Operation(
        operationId = "registerProduct",
        summary = "Cadastra produtos",
        description = "Cadastra produtos a partir da uma categoria",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Erro ao cadastrar"),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Produto inválido")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/painel/produto/cadastro",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> _registerProduct(
        @Parameter(name = "Produto", description = "", required = true) @Valid @RequestBody Produto produto
    ) {
        return registerProduct(produto);
    }

    // Override this method
    default  ResponseEntity<Void> registerProduct(Produto produto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /neighborfood/cliente : Envia mimo ao último cliente que realizou um pedido
     * Envia mimo ao cliente
     *
     * @param mimo  (required)
     * @return Mimo enviado (status code 200)
     *         or Id inválido (status code 400)
     *         or Mimo não disponível (status code 404)
     */
    @Operation(
        operationId = "sendBonus",
        summary = "Envia mimo ao último cliente que realizou um pedido",
        description = "Envia mimo ao cliente",
        tags = { "customers" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Mimo enviado"),
            @ApiResponse(responseCode = "400", description = "Id inválido"),
            @ApiResponse(responseCode = "404", description = "Mimo não disponível")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/neighborfood/cliente",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> _sendBonus(
        @Parameter(name = "Mimo", description = "", required = true) @Valid @RequestBody Mimo mimo
    ) {
        return sendBonus(mimo);
    }

    // Override this method
    default  ResponseEntity<Void> sendBonus(Mimo mimo) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
