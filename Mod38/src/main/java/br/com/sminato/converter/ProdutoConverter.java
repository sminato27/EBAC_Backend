package br.com.sminato.converter;

import br.com.sminato.domain.Produto;
import br.com.sminato.service.IProdutoService;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@FacesConverter(value = "produtoConverter", forClass = Produto.class, managed = true)
public class ProdutoConverter implements Converter<Produto> {

    @Inject
    private IProdutoService produtoService;

    @Override
    public Produto getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            Long id = Long.parseLong(value);
            return produtoService.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Produto value) {
        if (value == null || value.getId() == null) {
            return "";
        }
        return value.getId().toString();
    }
}
