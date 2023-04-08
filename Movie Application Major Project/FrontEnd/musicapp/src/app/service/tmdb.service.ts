import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TmdbService {

  constructor(private httpClient:HttpClient) { }

  base_url:string = "https://api.themoviedb.org/3";
  api_key:string = "be4f0b916284d6fa9b0909fb65140fb3";
  movieName:string | undefined;
  movieInfo: any;
  currentPage:number=1;
  recommendedMovieId:any;
  email:any;
  favMovieObj:any={};

  trendingApiData():Observable<any> {
    return this.httpClient.get(`${this.base_url}/trending/all/week?api_key=${this.api_key}`);
  }

  fetchActionMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=28`);
  }

  fetchAdventureMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=12`);
  }

  fetchAnimationMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=16`);
  }

  fetchComedyMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=35`);
  }

  fetchDocumentaryMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=99`);
  }

  fetchSciencefictionMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=878`);
  }

  fetchThrillerMovies():Observable<any> {
    return this.httpClient.get(`${this.base_url}/discover/movie?api_key=${this.api_key}&with_genres=53`);
  }

  getMovieDetails(data:any):Observable<any> {
    return this.httpClient.get(`${this.base_url}/movie/${data}?api_key=${this.api_key}`);
  }

  getMovieVideo(data:any):Observable<any> {
    return this.httpClient.get(`${this.base_url}/movie/${data}/videos?api_key=${this.api_key}`);
  }

  getMovieCast(data:any):Observable<any> {
    return this.httpClient.get(`${this.base_url}/movie/${data}/credits?api_key=${this.api_key}`);
  }

  getSearchMovie(data:any):Observable<any> {
    return this.httpClient.get(`${this.base_url}/search/movie?api_key=${this.api_key}&query=${data.searchItem}`);
  }

  getRecommendations(data:any):Observable<any> {
    return this.httpClient.get(`${this.base_url}/movie/${data}/recommendations?api_key=${this.api_key}&language=en-US&page=1`);
  }
  addMovieToFavourites(movieId:number,movieName:any){    
    this.favMovieObj.movieId=movieId;
    this.favMovieObj.movieName=movieName;
    this.favMovieObj.email=localStorage.getItem('email');
    console.log(this.favMovieObj);
    return this.httpClient.post("http://localhost:8081/api/v3/register",this.favMovieObj);
  }
  getAllFavouriteMoviesFromApi(movieId:number){
    let url = `https://api.themoviedb.org/3/movie/${movieId}?api_key=${this.api_key}&append_to_response=credits`;
    return this.httpClient.get<any>(url);
  }
  getFavouriteMoviesByEmail()
  {
    return this.httpClient.get("http://localhost:8086/api/v4/favourite/"+this.email)
  }
  deleteFavouriteMovie(delMovieId:String){
    return this.httpClient.delete("http://localhost:8086/api/v4/deleteFavourite/"+delMovieId+"/"+this.email);
  }
  deleteFavouriteFromMovieService(delMovieId:String){
    return this.httpClient.delete("http://localhost:8081/api/v3/deleteFavourite/"+delMovieId+"/"+this.email);
  }
}
