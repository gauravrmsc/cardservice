package in.dreamplug.demo.unittest.service;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
public class CreditLimitService {
    private TreeMap<Long, BiFunction<Long, Integer, Long>> creditLimitProviders;

    public CreditLimitService() {
        creditLimitProviders = new TreeMap<>();
        creditLimitProviders.put(25_000l, this::creditLimitLowSalary);
        creditLimitProviders.put(60_000l, this::creditLimitAverageSalary);
        creditLimitProviders.put(1_00_000l, this::creditLimitHighSalary);
    }

    public Long getCreditLimit(Long salary, Integer creditScore) {
        return Optional.ofNullable(creditLimitProviders.floorEntry(salary)).map(Map.Entry::getValue)
                       .map(creditLimitProvider -> creditLimitProvider.apply(salary, creditScore)).orElse(0l);
    }

    private Long creditLimitLowSalary(Long salary, Integer creditScore) {
        Integer creditScoreBucket = getCreditScoreBucket(creditScore);
        if (creditScoreBucket < 7) {
            return 0l;
        }
        switch (creditScoreBucket) {
            case 7:
                return (long) (0.4 * salary);
            case 8:
                return (long) (0.5 * salary);
        }
        return 0l;
    }

    private Long creditLimitAverageSalary(Long salary, Integer creditScore) {
        Integer creditScoreBucket = getCreditScoreBucket(creditScore);
        if (creditScoreBucket < 6) {
            return 0l;
        }
        switch (creditScoreBucket) {
            case 6:
                return (long) (0.4 * salary);
            case 7:
                return (long) (0.55 * salary);
            case 8:
                return (long) (0.6 * salary);
        }
        return 0l;
    }

    private Long creditLimitHighSalary(Long salary, Integer creditScore) {
        Integer creditScoreBucket = getCreditScoreBucket(creditScore);
        if (creditScoreBucket < 5) {
            return 0l;
        }
        switch (creditScoreBucket) {
            case 5:
                return (long) (0.3 * salary);
            case 6:
                return (long) (0.6 * salary);
            case 7:
                return (long) (0.8 * salary);
            case 8:
                return (long) (0.9 * salary);
        }
        return 0l;
    }

    private Integer getCreditScoreBucket(Integer creditScore) {
        return creditScore / 100;
    }
}


