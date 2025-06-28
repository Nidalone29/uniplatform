import { useCallback } from "react";
import { Moon, Sun } from "lucide-react";

import { Button } from "@/components/ui/button";

import { useTheme } from "@/components/common/ThemeProvider";

export function ModeToggle() {
  const { theme, setTheme } = useTheme();

  const toggleTheme = useCallback(() => {
    setTheme(theme === "dark" ? "light" : "dark");
  }, [theme, setTheme]);

  return (
    <Button
      variant="outline"
      size="default"
      className="group/toggle size-8"
      onClick={toggleTheme}
    >
      {theme == "light" ? <Sun /> : <Moon />}
    </Button>
  );
}
