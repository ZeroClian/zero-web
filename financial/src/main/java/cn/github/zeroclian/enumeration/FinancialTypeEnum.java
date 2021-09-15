package cn.github.zeroclian.enumeration;

import lombok.AllArgsConstructor;

/**
 * @Desciption
 * @Author: qiyiguo
 * @Date: 2021-09-15 11:19 上午
 */
@AllArgsConstructor
public enum FinancialTypeEnum implements Labeled {

    /**
     * 收入
     */
    IN("收入"),

    /**
     * 支出
     */
    OUT("支出");

    private final String label;

    @Override
    public String label() {
        return label;
    }
}
