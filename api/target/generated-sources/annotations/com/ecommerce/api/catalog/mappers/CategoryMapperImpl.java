package com.ecommerce.api.catalog.mappers;

import com.ecommerce.api.catalog.dto.input.CreateCategoryDto;
import com.ecommerce.api.catalog.dto.input.UpdateCategoryDto;
import com.ecommerce.api.catalog.dto.output.CategoryDto;
import com.ecommerce.api.catalog.models.Category;
import com.ecommerce.api.catalog.models.Category.CategoryBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T01:03:56+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setDescription( category.getDescription() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toCategoryDto(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( category.size() );
        for ( Category category1 : category ) {
            list.add( toCategoryDto( category1 ) );
        }

        return list;
    }

    @Override
    public Category toCategoryEntity(CreateCategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.name( categoryDto.getName() );
        category.description( categoryDto.getDescription() );

        return category.build();
    }

    @Override
    public Category toCategoryEntity(UpdateCategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.name( categoryDto.getName() );
        category.description( categoryDto.getDescription() );

        return category.build();
    }

    @Override
    public Category toCategoryEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.id( categoryDto.getId() );
        category.name( categoryDto.getName() );
        category.description( categoryDto.getDescription() );

        return category.build();
    }
}
