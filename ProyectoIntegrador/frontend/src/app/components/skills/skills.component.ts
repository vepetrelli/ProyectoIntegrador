import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  ski: Skills[] = [];

  constructor(private skillsS: SkillsService, private tokenService: TokenService) { }
  isLogged= false;

  ngOnInit(): void {
    this.cargarSkills();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else{this.isLogged = false;}
  }

  cargarSkills():void {
    this.skillsS.lista().subscribe(
      data => {this.ski = data;}
    )
  }

  delete(id:number){
    if(id!=undefined){
      this.skillsS.delete(id).subscribe(data => {this.cargarSkills();
      }, err => {
        alert("No se pudo eliminar")
      })
    }
  }
}
