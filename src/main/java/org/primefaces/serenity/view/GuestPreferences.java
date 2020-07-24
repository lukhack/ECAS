/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.serenity.view;

import co.com.lk.Bean.session.UsuarioB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class GuestPreferences implements Serializable {
    
    @Inject
    private UsuarioB usuarioB;
    
    private String layout = "medellin";
        
    private String theme = "bluegrey";
    
    private boolean darkMenu;

    private boolean horizontal = false;
    
    private boolean orientationRTL;
                            
    public String getTheme() {		
            return usuarioB.getTbUiUsuario().getTheme()==null?theme:usuarioB.getTbUiUsuario().getTheme();
    }

    public void setTheme(String theme) {
            this.theme = theme;
    }
    
    public String getLayout() {		
         return usuarioB.getTbUiUsuario().getLayout()==null?layout:usuarioB.getTbUiUsuario().getLayout();
    }
    
    public void setLayout(String layout) {
        this.layout = layout;
    }
    
    public boolean isDarkMenu() {		
        return darkMenu;
    }
    
    public void setDarkMenu(boolean darkMenu) {
        this.darkMenu = darkMenu;
    }

    public boolean isOrientationRTL() {
        return orientationRTL;
    }

    public void setOrientationRTL(boolean orientationRTL) {
        this.orientationRTL = orientationRTL;
    }

    public boolean isHorizontal() {
        return this.horizontal;
    }

    public void setHorizontal(boolean value) {
        this.horizontal = value;
    }

    public UsuarioB getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioB usuarioB) {
        this.usuarioB = usuarioB;
    }
    
    
}
