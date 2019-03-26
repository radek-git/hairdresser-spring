package com.radek.haidresser.specification;

import com.radek.haidresser.entity.Client;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;


@And({
        @Spec(path = "name", spec = Equal.class),
        @Spec(path = "surname", spec = Equal.class)
})
public interface ClientSpecification extends Specification<Client> {

}
