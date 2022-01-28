package waiters;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

@RequiredArgsConstructor
public enum WaitConditions {

    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy);

    private final BiFunction<?, ?, ExpectedCondition<?>> type;

    <T, V> WaitConditions(final Function<T, ExpectedCondition<?>> type) {
        this((T arg1, V arg2) -> type.apply(arg1));
    }

    public <T, V, R> BiFunction<T, V, R> getType() {
        return (BiFunction<T, V, R>) type;
    }
}
