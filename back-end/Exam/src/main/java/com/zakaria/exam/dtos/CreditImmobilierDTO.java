package com.zakaria.exam.dtos;

import com.zakaria.exam.enums.TypeBien;
import lombok.Data;

@Data
public class CreditImmobilierDTO extends CreditDTO{
    private TypeBien typeBien;

}
