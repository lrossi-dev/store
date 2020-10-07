package dev.lrossi.ecommerce.products.controller;

import dev.lrossi.ecommerce.products.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudController<R> {

    @PostMapping("/create")
    default ResponseEntity<R> create(@RequestBody @Validated R request) {
        return ResponseEntity.ok(getService().create(request));
    }

    @GetMapping("/find/{id}")
    default ResponseEntity<R> findById(@PathVariable Long id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @GetMapping("/find/all")
    default ResponseEntity<Page<R>> findAll(Pageable pageable) {
        return ResponseEntity.ok(getService().findAll(pageable));
    }

    default ResponseEntity<R> update(@RequestBody @Validated R request) {
        return ResponseEntity.ok(getService().update(request));
    }

    default ResponseEntity<Void> delete(@RequestBody @Validated R request) {
        getService().delete(request);
        return ResponseEntity.noContent().build();
    }

    CrudService<?, R> getService();
}
