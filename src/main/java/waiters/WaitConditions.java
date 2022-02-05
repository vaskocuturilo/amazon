package waiters;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

@RequiredArgsConstructor
public enum WaitConditions {
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy),
    enabled((Function<By, ExpectedCondition<?>>) ExpectedConditions::elementToBeClickable),
    present(ExpectedConditions::presenceOfElementLocated),
    visible(ExpectedConditions::visibilityOfElementLocated);


    private final BiFunction<?, ?, ExpectedCondition<?>> type;

    <T, V> WaitConditions(final Function<T, ExpectedCondition<?>> type) {
        this((T arg1, V arg2) -> type.apply(arg1));
    }

    public <T, V, R> BiFunction<T, V, R> getType() {
        return (BiFunction<T, V, R>) type;
    }
}
