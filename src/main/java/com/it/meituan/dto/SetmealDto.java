package com.it.meituan.dto;

import com.it.meituan.entity.Setmeal;
import com.it.meituan.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
