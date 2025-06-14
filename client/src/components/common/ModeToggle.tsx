import { Moon, Sun } from "lucide-react"

import { Button } from "@/components/ui/button"

import { useTheme } from "@/components/common/ThemeProvider"


export function ModeToggle() {
  const { theme, setTheme } = useTheme()
  return (
    <>
      {
        (theme == "light") ? (
          <Button
            variant="outline"
            size="icon"
            className="group/toggle size-8"
            onClick={() => setTheme("dark")}
          ><Sun /></Button>
        ) : (
          <Button
            variant="outline"
            size="icon"
            className="group/toggle size-8"
            onClick={() => setTheme("light")}
          ><Moon /></Button>
        )
      }
    </>
  )
}
