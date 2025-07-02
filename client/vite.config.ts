import tailwindcss from "@tailwindcss/vite";
import react from "@vitejs/plugin-react";
import path from "path";
import { defineConfig, loadEnv } from "vite";

// https://stackoverflow.com/a/70711383
// https://vite.dev/config/
export default ({ mode }: { mode: string }) => {
  const loadedViteEnv = loadEnv(mode, process.cwd() + "/..");

  if (loadedViteEnv.VITE_CLIENT_PORT_DEV === undefined) {
    console.error("unspecified dev port, fallback to default vite port 5173");
  }

  return defineConfig({
    plugins: [react(), tailwindcss()],
    resolve: {
      alias: {
        "@": path.resolve(__dirname, "./src"),
      },
    },
    envDir: "../",
    server: {
      strictPort: true,
      port: +loadedViteEnv.VITE_CLIENT_PORT_DEV,
    },
    build: {
      // generate .vite/manifest.json in outDir
      manifest: true,
    },
  });
};
