package com.ecommerce.api.catalog.mappers;

import com.ecommerce.api.catalog.dto.input.CreateProductDto;
import com.ecommerce.api.catalog.dto.output.ProductDto;
import com.ecommerce.api.catalog.models.Product;
import com.ecommerce.api.catalog.models.Product.ProductBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T12:38:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setCategory( categoryMapper.toCategoryDto( product.getCategory() ) );

        return productDto;
    }

    @Override
    public List<ProductDto> toDto(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    @Override
    public Product toEntity(CreateProductDto createProductDto) {
        if ( createProductDto == null ) {
            return null;
        }

        ProductBuilder product = Product.builder();

        product.name( createProductDto.getName() );
        product.description( createProductDto.getDescription() );
        product.price( createProductDto.getPrice() );

        return product.build();
    }
}
