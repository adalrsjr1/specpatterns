package com.github.adalrsjr1.automaton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface AutomatonListener {
	void notify(AutomatonEvent event);
}
