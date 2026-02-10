package br.com.sminato.converter;

import br.com.sminato.domain.Cliente;
import br.com.sminato.service.IClienteService;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@FacesConverter(value = "clienteConverter", forClass = Cliente.class, managed = true)
public class ClienteConverter implements Converter<Cliente> {

    @Inject
    private IClienteService clienteService;

    @Override
    public Cliente getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            Long id = Long.parseLong(value);
            return clienteService.consultar(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Cliente value) {
        if (value == null || value.getId() == null) {
            return "";
        }
        return value.getId().toString();
    }
}
